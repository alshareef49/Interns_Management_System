package com.interns.Service;

import com.interns.dto.MentorDTO;
import com.interns.dto.ProjectDTO;
import com.interns.entity.Mentor;
import com.interns.entity.Project;
import com.interns.exception.InternException;
import com.interns.repository.MentorRepository;
import com.interns.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectAllocationServiceImpl implements ProjectAllocationService{

    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<MentorDTO> getAllMentor(Integer numberOfProjectMentored) throws InternException{
        Iterable<Mentor> mentors = mentorRepository.findByNumberOfProjectMentored(numberOfProjectMentored);
        List<MentorDTO> mentorDTOs = new ArrayList<>();
        mentors.forEach(m->{
            MentorDTO mentorDTO = new MentorDTO();
            mentorDTO.setMentorId(m.getMentorId());
            mentorDTO.setMentorName(m.getMentorName());
            mentorDTO.setNumberOfProjectMentored(m.getNumberOfProjectMentored());
            mentorDTOs.add(mentorDTO);
        });
        if(mentorDTOs.isEmpty()){
            throw new InternException("Service.MENTOR_NOT_FOUND");
        }
        return mentorDTOs;
    }

    @Override
    public Integer allocateProject(ProjectDTO projectDTO) throws InternException{
        Optional<Mentor> optional = mentorRepository.findById(projectDTO.getMentorDTO().getMentorId());
        Mentor mentor = optional.orElseThrow(()-> new InternException("Service.MENTOR_NOT_FOUND"));
        if(mentor.getNumberOfProjectMentored()>=3){
            throw new InternException("Service.CANNOT_ALLOCATE_PROJECT");
        }
        Project project = new Project();
        project.setProjectName(projectDTO.getProjectName());
        project.setReleaseDate(projectDTO.getReleaseDate());
        project.setMentor(mentor);
        projectRepository.save(project);
        mentor.setNumberOfProjectMentored(mentor.getNumberOfProjectMentored()+1);
        return project.getProjectId();
    }

    @Override
    public void updateProjectMentor(Integer projectId,Integer mentorId) throws InternException{
        Optional<Mentor> optional = mentorRepository.findById(mentorId);
        Mentor mentor = optional.orElseThrow(()-> new InternException("Service.MENTOR_NOT_FOUND"));
        Optional<Project> optional1 = projectRepository.findById(projectId);
        Project project = optional1.orElseThrow(()-> new InternException("Service.PROJECT_NOT_FOUND"));
        if(mentor.getNumberOfProjectMentored()>=3){
            throw new InternException("Service.CANNOT_ALLOCATE_PROJECT");
        }
        project.setMentor(mentor);
        mentor.setNumberOfProjectMentored(mentor.getNumberOfProjectMentored()+1);
    }

    @Override
    public void deleteProject(Integer projectId) throws InternException{
        Optional<Project> optional = projectRepository.findById(projectId);
        Project project = optional.orElseThrow(()-> new InternException("Service.PROJECT_NOT_FOUND"));
        if(project.getMentor()!=null){
            Mentor mentor = project.getMentor();
            mentor.setNumberOfProjectMentored(mentor.getNumberOfProjectMentored()-1);
        }
        projectRepository.delete(project);
    }
}
