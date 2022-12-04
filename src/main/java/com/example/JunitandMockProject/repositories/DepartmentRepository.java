package com.example.JunitandMockProject.repositories;

import com.example.JunitandMockProject.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public List<Department> findAll();
    public Optional<Department> findById(Long id);
    void deleteById(Long aLong);
}
