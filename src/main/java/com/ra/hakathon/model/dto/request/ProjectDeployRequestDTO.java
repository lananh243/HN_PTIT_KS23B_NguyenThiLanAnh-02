package com.ra.hakathon.model.dto.request;

import com.ra.hakathon.model.entity.Project;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDeployRequestDTO {
    @NotBlank(message = "Tên người quản lý dự án ko đc để trống")
    private String managerName;
    @Min(value = 0, message = "Tổng số nhân viên tham gia phải > 0")
    private Integer totalEmployeeJoined;
    private MultipartFile imageManager;
    private Boolean status;
    private Project project;
}
