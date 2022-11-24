package com.bosonit.block7crudvalidation2.content.student.application.mapper;

import com.bosonit.block7crudvalidation2.content.person.application.mapper.PersonEntityToDTO;
import com.bosonit.block7crudvalidation2.content.professor.application.mapper.ProfessorEntityToDTO;
import com.bosonit.block7crudvalidation2.content.student.domain.StudentEntity;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentFullOutputDTO;
import com.bosonit.block7crudvalidation2.content.student.infrastructure.dto.StudentOutputDTO;

import java.util.ArrayList;
import java.util.List;

public class StudentEntityToDTO {
    public static StudentOutputDTO iniStudentDTO(StudentEntity student){
        StudentOutputDTO studentDTO = new StudentOutputDTO();

        studentDTO.setId(student.getId());
        studentDTO.setComents(student.getComments());
        studentDTO.setBranch(student.getBranch());
        studentDTO.setNum_hours_week(student.getNum_hours_week());

        studentDTO.setPerson(PersonEntityToDTO.iniPersonDTO(student.getPerson()));
        studentDTO.setProfessor(ProfessorEntityToDTO.iniProfessorDTO(student.getProfessor()));

        return studentDTO;
    }

    public static StudentFullOutputDTO iniStudentFullDTO(StudentEntity student){
        StudentFullOutputDTO studentDTO = new StudentFullOutputDTO();

        studentDTO.setId_student(student.getId());
        studentDTO.setNum_hours_week(student.getNum_hours_week());
        studentDTO.setComments(student.getComments());
        studentDTO.setBranch(student.getBranch());

        studentDTO.setId_person(student.getPerson().getId_person());
        studentDTO.setUsername(student.getPerson().getUsername());
        studentDTO.setPassword(student.getPerson().getPassword());
        studentDTO.setName(student.getPerson().getName());
        studentDTO.setSurname(student.getPerson().getSurname());
        studentDTO.setCompany_email(student.getPerson().getCompany_email());
        studentDTO.setPersonal_email(student.getPerson().getPersonal_email());
        studentDTO.setCity(student.getPerson().getCity());
        studentDTO.setImg_url(student.getPerson().getImg_url());
        studentDTO.setActive(student.getPerson().isActive());
        studentDTO.setCreated_date(student.getPerson().getCreated_date());
        studentDTO.setTermination_date(student.getPerson().getTermination_date());

        return studentDTO;
    }

    public static List<StudentOutputDTO> iniStudentDTO(List<StudentEntity> student){
        List<StudentOutputDTO> StudentOutputDTO = new ArrayList<>();

        for(StudentEntity i : student){
            StudentOutputDTO.add(iniStudentDTO(i));
        }

        return StudentOutputDTO;
    }

    public static List<StudentFullOutputDTO> iniStudentFullDTO(List<StudentEntity> student){
        List<StudentFullOutputDTO> StudentOutputDTO = new ArrayList<>();

        for(StudentEntity i : student){
            StudentOutputDTO.add(iniStudentFullDTO(i));
        }

        return StudentOutputDTO;
    }
}
