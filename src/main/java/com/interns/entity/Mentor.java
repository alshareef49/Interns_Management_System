package com.interns.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Mentor {
    @Id
    private Integer mentorId;
    private String mentorName;
    private Integer numberOfProjectMentored;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mentor mentor)) return false;
        return Objects.equals(mentorId, mentor.mentorId) && Objects.equals(mentorName, mentor.mentorName) && Objects.equals(numberOfProjectMentored, mentor.numberOfProjectMentored);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mentorId, mentorName, numberOfProjectMentored);
    }
}
