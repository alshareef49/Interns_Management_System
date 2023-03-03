package com.interns.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectId;
    private String projectName;
    private LocalDate releaseDate;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

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

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return Objects.equals(projectId, project.projectId) && Objects.equals(projectName, project.projectName) && Objects.equals(releaseDate, project.releaseDate) && Objects.equals(mentor, project.mentor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectName, releaseDate, mentor);
    }
}
