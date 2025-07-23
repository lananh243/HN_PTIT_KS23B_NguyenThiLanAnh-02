package com.ra.hakathon.controller;

import com.ra.hakathon.model.dto.request.ProjectDeployRequestDTO;
import com.ra.hakathon.model.dto.response.APIResponse;
import com.ra.hakathon.model.entity.ProjectDeploy;
import com.ra.hakathon.service.ProjectDeployService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project-deployes")
public class ProjectDeployController {
    @Autowired
    private ProjectDeployService projectDeployService;

    @GetMapping
    public ResponseEntity<APIResponse<List<ProjectDeploy>>> getAll() {
        List<ProjectDeploy> projectDeploys = projectDeployService.findAll();
        return new ResponseEntity<>(new APIResponse<>(true, "Lấy danh sách thành công", projectDeploys, HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse<ProjectDeploy>> create(@ModelAttribute @Valid ProjectDeployRequestDTO projectDeployRequest) {
        return new ResponseEntity<>(new APIResponse<>(true, "Thêm thành công", projectDeployService.save(projectDeployRequest), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<ProjectDeploy>> update(@PathVariable Integer id, @ModelAttribute @Valid ProjectDeployRequestDTO projectDeployRequest) {
        ProjectDeploy updated = projectDeployService.update(projectDeployRequest, id);
        return new ResponseEntity<>(new APIResponse<>(true, "Cập nhật thành công", updated, HttpStatus.OK), HttpStatus.OK);
    }
}
