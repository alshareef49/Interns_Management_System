package com.interns.dto;

import java.time.LocalDate;

public class projectDTO {
    private Integer projectId;
    private String projectName;
    private LocalDate releaseDate;

    private MentorDTO mentorDTO;

    public projectDTO(){
        super();
    }
    public projectDTO(Integer projectId, String projectName, LocalDate releaseDate, MentorDTO mentorDTO) {
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
