package com.interns.Service;

import com.interns.dto.MentorDTO;
import com.interns.entity.Mentor;
import com.interns.exception.InternException;
import com.interns.repository.MentorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectAllocationServiceImpl implements ProjectAllocationService{

    @Autowired
    private MentorRepository mentorRepository;

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
}
