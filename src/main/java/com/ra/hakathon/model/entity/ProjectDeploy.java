package com.ra.hakathon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDeploy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_deploy_id")
    private Integer projectDeployId;

    @Column(name = "manager_name", nullable = false)
    private String managerName;

    @Column(name = "total_employee_joined", nullable = false)
    private Integer totalEmployeeJoined;

    @Column(name = "image_manager")
    private String imageManager;

    private Boolean status;

    @ManyToOne
    @JoinTable(name = "project_id")
    private Project project_id;

}
