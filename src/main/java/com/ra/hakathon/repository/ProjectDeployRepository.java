package com.ra.hakathon.repository;

import com.ra.hakathon.model.entity.ProjectDeploy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDeployRepository extends JpaRepository<ProjectDeploy, Integer> {
}
