package com.ra.hakathon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;
    @Column(name = "project_name", nullable = false, unique = true)
    private String projectName;
    @Column(name = "technology_using", nullable = false)
    private String technologyUsing;

    @Column(nullable = false)
    private LocalDateTime start_date;
    private Boolean status;
}
