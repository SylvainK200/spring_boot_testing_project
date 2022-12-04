package com.example.JunitandMockProject.repositories;

import com.example.JunitandMockProject.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    public List<Teacher> findAll();
    public Optional<Teacher> findById(Long id);
    public void deleteById(Long id);
}
