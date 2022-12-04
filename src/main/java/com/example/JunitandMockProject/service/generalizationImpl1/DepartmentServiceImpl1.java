package com.example.JunitandMockProject.service.generalizationImpl1;

import com.example.JunitandMockProject.entities.Department;
import com.example.JunitandMockProject.repositories.DepartmentRepository;
import com.example.JunitandMockProject.service.dtos.DepartmentDto;
import com.example.JunitandMockProject.service.generalizations.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl1 implements DepartementService {
    @Autowired
    private  DepartmentRepository departmentRepository;


    @Override
    public List<DepartmentDto> findAllDepartments() {
        return departmentRepository.findAll().stream().map(department -> department.departmentToDTO(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto findById(Long id) {
        Department department = new Department("","");
        return department.departmentToDTO(departmentRepository.findById(id).get());
    }

    @Override
    public Long deleteById(Long id) {
        departmentRepository.deleteById(id);
        return id;
    }
}
