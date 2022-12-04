package com.example.JunitandMockProject.controller;

import com.example.JunitandMockProject.service.dtos.TeacherDto;
import com.example.JunitandMockProject.service.generalizations.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public List<TeacherDto> findAllTeachers(){
        return teacherService.findAllTeachers();
    }

    @RequestMapping(value = "/teacher/{id}",method = RequestMethod.GET)
    public TeacherDto findTeacherById(@PathVariable Long id ){
        return teacherService.findById(id);
    }

    @RequestMapping(value= "/teacher/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id ){
        teacherService.deleteById(id);
    }


}
