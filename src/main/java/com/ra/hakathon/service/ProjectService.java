package com.ra.hakathon.service;

import com.ra.hakathon.model.dto.request.ProjectRequestDTO;
import com.ra.hakathon.model.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project findById(Integer id);
    Project save(ProjectRequestDTO projectRequest);
    Project update(ProjectRequestDTO projectRequest, Integer id);
    void delete(Integer id);
}
