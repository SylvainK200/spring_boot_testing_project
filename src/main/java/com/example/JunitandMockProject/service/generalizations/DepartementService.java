package com.example.JunitandMockProject.service.generalizations;

import com.example.JunitandMockProject.service.dtos.DepartmentDto;

import java.util.List;

public interface DepartementService {
    List<DepartmentDto> findAllDepartments();
    DepartmentDto findById(Long id);
    Long deleteById(Long id);
}
