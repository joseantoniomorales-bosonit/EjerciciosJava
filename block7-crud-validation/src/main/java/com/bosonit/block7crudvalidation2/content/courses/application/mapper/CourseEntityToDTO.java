package com.bosonit.block7crudvalidation2.content.courses.application.mapper;

import com.bosonit.block7crudvalidation2.content.courses.domain.CourseEntity;
import com.bosonit.block7crudvalidation2.content.courses.infrastructure.dto.CourseOutputDTO;

import java.util.ArrayList;
import java.util.List;

public class CourseEntityToDTO {
    public static CourseOutputDTO iniCourseDTO(CourseEntity course){
        CourseOutputDTO courseDTO = new CourseOutputDTO();

        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setComment(course.getComment());
        courseDTO.setInitial_date(course.getInitial_date());
        courseDTO.setFinish_date(course.getFinish_date());

        //courseDTO.setProfessor(course.getProfessor());
        //courseDTO.setStudent(course.getStudent());

        return courseDTO;
    }

    public static List<CourseOutputDTO> iniCourseDTO(List<CourseEntity> course){
        List<CourseOutputDTO> courseDTO = new ArrayList<>();

        for(CourseEntity i : course){
            courseDTO.add(iniCourseDTO(i));
        }

        return courseDTO;
    }
}
