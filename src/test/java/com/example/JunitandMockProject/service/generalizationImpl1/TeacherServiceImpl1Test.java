package com.example.JunitandMockProject.service.generalizationImpl1;

import com.example.JunitandMockProject.entities.Teacher;
import com.example.JunitandMockProject.repositories.TeacherRepository;
import com.example.JunitandMockProject.service.dtos.TeacherDto;
import com.example.JunitandMockProject.service.generalizations.TeacherService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImpl1Test {

    @Mock
    private TeacherRepository teacherRepository ;
    @InjectMocks
    private TeacherServiceImpl1 underTest;

    Teacher teacher ;
    Teacher secondTeacher;
    @BeforeEach
    void setUp(){
       // underTest = new TeacherServiceImpl1(teacherRepository);
        teacher = Teacher.builder()
                .name("Teacher")
                .grade("Prof")
                .speciality("Software Engineering")
                .build();
        secondTeacher= Teacher.builder()
                .name("Teacher2")
                .grade("Prof2")
                .speciality("Software Engineering after all")
                .build();
    }


    @Test
    void save() {
        TeacherDto teacherDto = Teacher.teacherToDTO(teacher);
        TeacherDto testReturn =TeacherDto.builder()
                .name("Teacher")
                .speciality("Software Engineering")
                .build();
        underTest.saveTeacher(teacherDto);
        ArgumentCaptor<Teacher> teacherArgumentCaptor = ArgumentCaptor.forClass(Teacher.class);
        verify(teacherRepository).save(teacherArgumentCaptor.capture());
        Teacher teacher1 = teacherArgumentCaptor.getValue();
        assertEquals(teacher1.teacherToDTO(teacher1),testReturn);

    }

    @Test
    void save2(){

        when(teacherRepository.save(teacher)).thenReturn(Teacher.builder()
                .name("Teacher")
                .grade("Prof")
                .speciality("Software Engineering")
                        .id(1L)
                .build());
        TeacherDto mustReturn =TeacherDto.builder()
                .name("Teacher")
                .grade("Prof")
                .speciality("Software Engineering")
                .build();
        TeacherDto returned = underTest.saveTeacher(Teacher.teacherToDTO(teacher));
        assertEquals(mustReturn,returned);
    }

    @Test
    @Disabled
    void deleteById() {
    }

    @Test
    void findAllTeachers() {
        // when
        underTest.findAllTeachers();

        //then
        verify(teacherRepository).findAll();

    }
}