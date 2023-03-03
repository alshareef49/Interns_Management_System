package com.interns.api;

import com.interns.Service.ProjectAllocationServiceImpl;
import com.interns.dto.MentorDTO;
import com.interns.dto.ProjectDTO;
import com.interns.exception.InternException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/project")
    public ResponseEntity<String> projectAllocate(@RequestBody ProjectDTO projectDTO) throws InternException{
        Integer projectId = projectAllocationService.allocateProject(projectDTO);
        String successMessage = environment.getProperty("API.ALLOCATION_SUCCESS")+": "+projectId;
        return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
    }

    @PutMapping("/project/{projectId}/{mentorId}")
    public ResponseEntity<String> updateProjectMentor(@PathVariable Integer projectId,@PathVariable Integer mentorId) throws InternException{
        projectAllocationService.updateProjectMentor(projectId,mentorId);
        String successMessage = environment.getProperty("API.PROJECT_UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage,HttpStatus.OK);
    }

}
