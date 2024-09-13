package com.practice.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ob_projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate starDate;

    public Project() {
    }

    public Project(Long id, String title, LocalDate starDate) {
        this.id = id;
        this.title = title;
        this.starDate = starDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", starDate=" + starDate +
                '}';
    }
}
