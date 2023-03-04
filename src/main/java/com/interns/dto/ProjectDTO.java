package com.interns.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ProjectDTO {
    private Integer projectId;
    @NotNull(message = "{project.projectname.absent}")
    private String projectName;
    @NotNull(message = "{project.releasedate.absent}")
    private LocalDate releaseDate;

    @Valid
    @NotNull(message = "{project.mentor.absent}")
    private MentorDTO mentorDTO;

    public ProjectDTO(){
        super();
    }
    public ProjectDTO(Integer projectId, String projectName, LocalDate releaseDate, MentorDTO mentorDTO) {
        super();
        this.projectId = projectId;
        this.projectName = projectName;
        this.releaseDate = releaseDate;
        this.mentorDTO = mentorDTO;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MentorDTO getMentorDTO() {
        return mentorDTO;
    }

    public void setMentorDTO(MentorDTO mentorDTO) {
        this.mentorDTO = mentorDTO;
    }
}
