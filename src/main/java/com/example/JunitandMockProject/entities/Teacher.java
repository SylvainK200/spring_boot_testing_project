package com.example.JunitandMockProject.entities;

import com.example.JunitandMockProject.service.dtos.TeacherDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private String name ;
    private String grade ;
    private String speciality;
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    public static TeacherDto teacherToDTO(Teacher teacher){
        return  TeacherDto.builder()
                .speciality(teacher.getSpeciality())
                .grade(teacher.getGrade())
                .name(teacher.getName())
                .id(teacher.getId())
                .build();
    }
    public static  Teacher dtoToTeacher(TeacherDto teacherDto){
        return Teacher.builder()
                .name(teacherDto.getName())
                .grade(teacherDto.getGrade())
                .speciality(teacherDto.getSpeciality())
                .build();
    }

}
