package com.example.JunitandMockProject.service.generalizationImpl1;

import com.example.JunitandMockProject.entities.Teacher;
import com.example.JunitandMockProject.repositories.TeacherRepository;
import com.example.JunitandMockProject.service.dtos.TeacherDto;
import com.example.JunitandMockProject.service.generalizations.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl1 implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto findById(Long id) {
        Teacher teacher = new Teacher();
        return teacher.teacherToDTO(teacherRepository.findById(id).get());
    }

    @Override
    public Long deleteById(Long id) {
        deleteById(id);
        return id;
    }

    @Override
    public List<TeacherDto> findAllTeachers() {
        return teacherRepository.findAll().stream().map(elt -> elt.teacherToDTO(elt)).collect(Collectors.toList());
    }
}
