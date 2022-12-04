package com.example.JunitandMockProject.entities;

import com.example.JunitandMockProject.service.dtos.DepartmentDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String name ;
    private String department_leader ;
   @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    public Department(String name , String department_leader){
        this.name = name;
        this.department_leader = department_leader;
    }

    public Long getId(){
        return  this.id;
    }

    public DepartmentDto departmentToDTO(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartment_leader(department.getDepartment_leader());
        departmentDto.setName(department.getName());
        departmentDto.setId(departmentDto.getId());
        return  departmentDto;

    }
}
