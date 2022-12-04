package com.example.JunitandMockProject.repositories;

import com.example.JunitandMockProject.entities.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @AfterEach
    void tearDown(){
        departmentRepository.deleteAll();
    }
    @Test
    void findTestAll() {
        Department dep = Department.builder()
                .name("kouemo")
                .department_leader("kouema")
                .build();
        Department dep2 = Department.builder()
                .name("informatique")
                .department_leader("department leader")
                .build();
        List<Department> departments = new ArrayList<>();
        departments.add(dep);
        departments.add(dep2);
        departmentRepository.saveAll(departments);

        List<Department> departmentDtos = departmentRepository.findAll();
        assertTrue(departmentDtos.size()==2);
    }

    @Test
    void findTestById() {
        Department department = new Department("Kouemo","Computer science");
        departmentRepository.save(department);
        Optional<Department> dept = departmentRepository.findById(department.getId());
        assertTrue(dept.isPresent());
    }

    @Test
    void deleteTestById() {
        Department department = new Department("Kouemo","Computer science");
        departmentRepository.save(department);
        departmentRepository.deleteById(department.getId());
        List<Department> departments = departmentRepository.findAll();
        assertTrue(departments.size()==0);
    }
}