package com.interns.Service;

import com.interns.dto.MentorDTO;
import com.interns.dto.ProjectDTO;
import com.interns.exception.InternException;

import java.util.List;

public interface ProjectAllocationService {
    public List<MentorDTO> getAllMentor(Integer numberOfProjectMentored) throws InternException;
    public Integer allocateProject(ProjectDTO projectDTO) throws InternException;
    public void updateProjectMentor(Integer projectId,Integer mentorId) throws InternException;
    public void deleteProject(Integer projectId) throws InternException;
}
