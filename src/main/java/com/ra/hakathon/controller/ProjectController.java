package com.ra.hakathon.controller;

import com.ra.hakathon.model.dto.request.ProjectRequestDTO;
import com.ra.hakathon.model.dto.response.APIResponse;
import com.ra.hakathon.model.entity.Project;
import com.ra.hakathon.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Project>>> getAllProjects() {
        List<Project> projects = projectService.findAll();
        return new ResponseEntity<>(new APIResponse<>(true, "Lấy danh sách dự án thành công", projects, HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Project>> save(@RequestBody @Valid ProjectRequestDTO projectRequest) {
        return new ResponseEntity<>(new APIResponse<>(true, "Thêm mới thành công", projectService.save(projectRequest), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<APIResponse<Project>> update(@PathVariable("projectId") Integer projectId, @RequestBody @Valid ProjectRequestDTO projectRequest) {
        Project updateProject = projectService.update(projectRequest, projectId);
        return new ResponseEntity<>(new APIResponse<>(true, "Cập nhật thành công", updateProject, HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<APIResponse<?>> delete(@PathVariable("projectId") Integer projectId) {
        Project project = projectService.findById(projectId);
        if (project != null) {
            projectService.delete(projectId);
            return new ResponseEntity<>(new APIResponse<>(true, "Xóa thành công",  project, HttpStatus.OK), HttpStatus.OK);
        }
        return new ResponseEntity<>(new APIResponse<>(false, "Ko tìm thấy dự án với ID :"+projectId, null, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
