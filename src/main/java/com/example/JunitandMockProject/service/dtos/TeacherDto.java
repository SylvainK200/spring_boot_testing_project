package com.example.JunitandMockProject.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherDto {
    private Long id ;

    private String name ;
    private String grade ;
    private String speciality;

    private DepartmentDto departmentDto;

}
