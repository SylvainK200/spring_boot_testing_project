package com.example.JunitandMockProject.service.generalizations;

import com.example.JunitandMockProject.entities.Teacher;
import com.example.JunitandMockProject.service.dtos.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto findById(Long id);
    Long deleteById(Long id);
    List<TeacherDto> findAllTeachers();
    TeacherDto saveTeacher(TeacherDto teacher);
}
