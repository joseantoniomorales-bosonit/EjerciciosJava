package com.bosonit.block7crudvalidation2.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "feignProfesor", url = "http://localhost:8081")
public interface ProfessorFeign {

    @GetMapping("/profesor/{id}")
    String getProfesor(@PathVariable int id);
}
