package com.interns.dto;

public class MentorDTO {
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
