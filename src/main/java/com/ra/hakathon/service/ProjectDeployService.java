package com.ra.hakathon.service;

import com.ra.hakathon.model.dto.request.ProjectDeployRequestDTO;
import com.ra.hakathon.model.entity.ProjectDeploy;

import java.util.List;

public interface ProjectDeployService {
    List<ProjectDeploy> findAll();
    ProjectDeploy findById(Integer id);
    ProjectDeploy save(ProjectDeployRequestDTO projectDeployRequest);
    ProjectDeploy update(ProjectDeployRequestDTO projectDeployRequest, Integer id);
    void delete(Integer id);
}
