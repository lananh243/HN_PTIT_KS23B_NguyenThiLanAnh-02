package com.ra.hakathon.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {
    @NotBlank(message = "Tên dự án không được để trống")
    private String projectName;
    @NotBlank(message = "Công nghệ sử dụng ko đc để trống")
    private String technologyUsing;
    @NotNull(message = "Ngày bắt đầu triển khai ko đc để trống")
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
    private LocalDateTime start_date;
    private Boolean status;
}
