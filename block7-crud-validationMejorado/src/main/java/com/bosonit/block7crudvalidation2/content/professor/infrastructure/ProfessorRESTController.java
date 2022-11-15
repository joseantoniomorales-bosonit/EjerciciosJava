package com.bosonit.block7crudvalidation2.content.professor.infrastructure;

import com.bosonit.block7crudvalidation2.content.professor.application.service.ProfessorServiceImp;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profesor")
public class ProfessorRESTController {
    @Autowired
    ProfessorServiceImp professorService;

    @GetMapping("show")
    public void showAll(){

    }

    @GetMapping("show/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") Integer id){
        return professorService.findById(id);
    }

    @PostMapping("create")
    public ResponseEntity<Object> create(@RequestBody ProfessorInputDTO professor) throws Exception{
        return professorService.create(professor);
    }

    @PutMapping("edit")
    public void modify(){

    }

    @DeleteMapping("destroy/{id}")
    public void delete(@PathVariable(value="id") Integer id){

    }
}
