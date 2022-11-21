package com.bosonit.block7crudvalidation2.content.student.application.mapper;

import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentFullOutputDTO;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentInputDTO;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentOutputDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentDTOToEntity {
    public static StudentEntity iniStudentEntity(StudentInputDTO studentDTO){
        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId(studentDTO.getId());
        studentEntity.setComments(studentDTO.getComments());
        studentEntity.setBranch(studentDTO.getBranch());
        studentEntity.setNum_hours_week(studentDTO.getNum_hours_week());

        return studentEntity;
    }

    public static List<StudentEntity> iniStudentEntity(List<StudentInputDTO> student){
        List<StudentEntity> StudentEntity = new ArrayList<>();

        for(StudentInputDTO i : student){
            StudentEntity.add(iniStudentEntity(i));
        }

        return StudentEntity;
    }
}
