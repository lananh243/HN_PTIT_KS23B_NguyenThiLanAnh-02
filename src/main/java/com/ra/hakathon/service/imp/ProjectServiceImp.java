package com.ra.hakathon.service.imp;

import com.ra.hakathon.model.dto.request.ProjectRequestDTO;
import com.ra.hakathon.model.entity.Project;
import com.ra.hakathon.repository.ProjectRepository;
import com.ra.hakathon.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Integer id) {
        return projectRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Project not found"));
    }

    @Override
    public Project save(ProjectRequestDTO projectRequest) {
        Project project = Project.builder()
                .projectName(projectRequest.getProjectName())
                .technologyUsing(projectRequest.getTechnologyUsing())
                .start_date(projectRequest.getStart_date())
                .status(true)
                .build();
        return projectRepository.save(project);
    }

    @Override
    public Project update(ProjectRequestDTO projectRequest, Integer id) {
        Project oldProject = projectRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Project not found"));

        oldProject.setProjectName(projectRequest.getProjectName());
        oldProject.setTechnologyUsing(projectRequest.getTechnologyUsing());
        oldProject.setStart_date(projectRequest.getStart_date());
        oldProject.setStatus(true);
        return projectRepository.save(oldProject);

    }

    @Override
    public void delete(Integer id) {
        Project project = projectRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Project not found"));
        project.setStatus(false);
        projectRepository.save(project);
    }
}
