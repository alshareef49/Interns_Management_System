package com.interns.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class MentorDTO {

    @Min(value = 1000,message = "{mentor.mentorid.invalid}")
    @Max(value = 9999,message = "{mentor.mentorid.invalid}")
    @NotNull(message = "{mentor.mentorid.absent}")
    private Integer mentorId;
    private String mentorName;
    private Integer numberOfProjectMentored;

    public MentorDTO(){
        super();
    }
    public MentorDTO(Integer mentorId, String mentorName, Integer numberOfProjectMentored) {
        super();
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.numberOfProjectMentored = numberOfProjectMentored;
    }

    public Integer getMentorId() {
        return mentorId;
    }

    public void setMentorId(Integer mentorId) {
        this.mentorId = mentorId;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public Integer getNumberOfProjectMentored() {
        return numberOfProjectMentored;
    }

    public void setNumberOfProjectMentored(Integer numberOfProjectMentored) {
        this.numberOfProjectMentored = numberOfProjectMentored;
    }
}
