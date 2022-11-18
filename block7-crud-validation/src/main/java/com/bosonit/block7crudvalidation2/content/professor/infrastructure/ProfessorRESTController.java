package com.bosonit.block7crudvalidation2.content.professor.infrastructure;

import com.bosonit.block7crudvalidation2.content.professor.application.service.ProfessorServiceImp;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.input.ProfessorInputDTO;
import com.bosonit.block7crudvalidation2.content.professor.infrastructure.dto.output.ProfessorOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return professorService.createProfessor(professor);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Object> modify(@PathVariable(value="id") int id, @RequestBody ProfessorInputDTO professorInputDTO) throws Exception{
        return professorService.modifyProfessor(id,professorInputDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value="id") Integer id) throws Exception{
        return professorService.deleteProfessor(id);
    }
}
