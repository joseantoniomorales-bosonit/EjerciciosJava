package com.bosonit.block7crudvalidation2.content.courses.application.mapper;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseInputDTO;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseOutputDTO;

import java.util.ArrayList;
import java.util.List;

public class CourseDTOToEntity {
    public static CourseEntity iniCourseEntity(CourseInputDTO courseDTO){
        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId(courseDTO.getId());
        courseEntity.setName(courseDTO.getName());
        courseEntity.setComment(courseDTO.getComment());
        courseEntity.setInitial_date(courseDTO.getInitial_date());
        courseEntity.setFinish_date(courseDTO.getFinish_date());

        //courseEntity.setProfessor(courseDTO.getProfessor());
        //courseEntity.setStudent(courseDTO.getStudent());

        return courseEntity;
    }

    public static List<CourseEntity> iniCourseEntity(List<CourseInputDTO> courseDTO){
        List<CourseEntity> courseEntity = new ArrayList<>();

        for(CourseInputDTO i : courseDTO){
            courseEntity.add(iniCourseEntity(i));
        }

        return courseEntity;
    }
}
