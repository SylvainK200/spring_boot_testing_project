package com.example.JunitandMockProject.controller;

import com.example.JunitandMockProject.service.dtos.DepartmentDto;
import com.example.JunitandMockProject.service.generalizations.DepartementService;
import com.example.JunitandMockProject.service.generalizations.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DepartmentController {
    @Autowired
    private DepartementService departementService;

    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public List<DepartmentDto> findAllDepartments(){
        return departementService.findAllDepartments();
    }

    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
    public DepartmentDto findDepartmentById(@PathVariable Long id ){
        return departementService.findById(id);
    }

    @RequestMapping(value= "/department/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id ){
        departementService.deleteById(id);
    }

}
