package com.interns.api;

import com.interns.Service.ProjectAllocationServiceImpl;
import com.interns.dto.MentorDTO;
import com.interns.exception.InternException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interns")
public class InternAPI {

    @Autowired
    private ProjectAllocationServiceImpl projectAllocationService;
    @Autowired
    private Environment environment;

    @GetMapping("/mentor/{numberOfProject}")
    public ResponseEntity<List<MentorDTO>> getAllMentor(@PathVariable Integer numberOfProject) throws InternException{
        List<MentorDTO> mentors = projectAllocationService.getAllMentor(numberOfProject);
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }

}
