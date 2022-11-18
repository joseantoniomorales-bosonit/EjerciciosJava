package com.bosonit.block7crudvalidation2.content.student.application.mapper;

import com.bosonit.block7crudvalidation2.content.student.domain.entity.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentOutputDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentEntityToDTO {
    public static StudentOutputDTO iniStudentDTO(StudentEntity student){
        StudentOutputDTO studentDTO = new StudentOutputDTO();

        studentDTO.setId(student.getId());
        studentDTO.setComents(student.getComents());
        studentDTO.setBranch(student.getBranch());
        studentDTO.setNum_hours_week(student.getNum_hours_week());

        return studentDTO;
    }

    public static List<StudentOutputDTO> iniStudentDTO(List<StudentEntity> student){
        List<StudentOutputDTO> StudentOutputDTO = new ArrayList<>();

        for(StudentEntity i : student){
            StudentOutputDTO.add(iniStudentDTO(i));
        }

        return StudentOutputDTO;
    }
}
