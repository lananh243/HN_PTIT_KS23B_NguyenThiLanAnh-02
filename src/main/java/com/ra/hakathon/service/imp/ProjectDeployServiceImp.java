package com.ra.hakathon.service.imp;

import com.ra.hakathon.model.dto.request.ProjectDeployRequestDTO;
import com.ra.hakathon.model.entity.ProjectDeploy;
import com.ra.hakathon.repository.ProjectDeployRepository;
import com.ra.hakathon.service.CloudinaryService;
import com.ra.hakathon.service.ProjectDeployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectDeployServiceImp implements ProjectDeployService {
    @Autowired
    private ProjectDeployRepository projectDeployRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public List<ProjectDeploy> findAll() {
        return projectDeployRepository.findAll();
    }

    @Override
    public ProjectDeploy findById(Integer id) {
        return projectDeployRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Project Deploy Not Found"));
    }

    @Override
    public ProjectDeploy save(ProjectDeployRequestDTO projectDeployRequest) {
        String imageManager = cloudinaryService.uploadImage(projectDeployRequest.getImageManager());
        ProjectDeploy projectDeploy = new ProjectDeploy();
        projectDeploy.setManagerName(projectDeployRequest.getManagerName());
        projectDeploy.setTotalEmployeeJoined(projectDeployRequest.getTotalEmployeeJoined());
        projectDeploy.setStatus(true);
        projectDeploy.setImageManager(imageManager);
        return projectDeployRepository.save(projectDeploy);
    }
    @Override
    public ProjectDeploy update(ProjectDeployRequestDTO projectDeployRequest, Integer id) {
        ProjectDeploy projectDeploy = findById(id);
        if (projectDeploy != null) {
            ProjectDeploy updatedProjectDeploy = ProjectDeploy.builder()
                    .managerName(projectDeployRequest.getManagerName())
                    .totalEmployeeJoined(projectDeployRequest.getTotalEmployeeJoined())
                    .status(true)
                    .build();
            updatedProjectDeploy.setProjectDeployId(id);
            if (projectDeployRequest.getImageManager() != null && !projectDeployRequest.getImageManager().isEmpty()) {
                updatedProjectDeploy.setImageManager(cloudinaryService.uploadImage(projectDeployRequest.getImageManager()));
            }else {
                updatedProjectDeploy.setImageManager(projectDeploy.getImageManager());
            }
            return projectDeployRepository.save(updatedProjectDeploy);
        }else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {

    }
}
