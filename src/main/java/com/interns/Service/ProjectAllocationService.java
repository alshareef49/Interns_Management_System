package com.interns.Service;

import com.interns.dto.MentorDTO;
import com.interns.exception.InternException;

import java.util.List;

public interface ProjectAllocationService {
    List<MentorDTO> getAllMentor(Integer numberOfProjectMentored) throws InternException;
    
}
