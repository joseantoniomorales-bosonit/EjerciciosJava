package com.bosonit.block7crudvalidation2.content.professor.infrastructure.controller;

import com.bosonit.block7crudvalidation2.content.professor.application.service.ProfessorServiceImp;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;
import com.bosonit.block7crudvalidation2.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("profesor")
public class ProfessorRESTController {
    @Autowired
    ProfessorServiceImp professorService;

    @GetMapping("")
    public List<ProfessorOutputDTO> showAll(){
        return professorService.getAll();
    }

    @GetMapping("show/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") Integer id){
        return professorService.findById(id);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody ProfessorInputDTO professor) throws Exception{
        try{
            return professorService.createProfessor(professor);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Object> modify(@PathVariable(value="id") int id, @RequestBody ProfessorInputDTO professorInputDTO) throws Exception{
        try{
            return professorService.modifyProfessor(id,professorInputDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") Integer id) throws Exception{
        try{
            return professorService.deleteProfessor(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(422).body(new CustomError(new Date(), 422,"UnprocessableEntityException").toString());
        }
    }
}
