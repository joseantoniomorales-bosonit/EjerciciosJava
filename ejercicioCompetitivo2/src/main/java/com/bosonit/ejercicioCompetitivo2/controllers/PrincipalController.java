package com.bosonit.ejercicioCompetitivo2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PrincipalController {

    @GetMapping(value={"/**"})
    public ControllerObject entryOther(HttpServletRequest request){
        List<String> path = Arrays.stream(request.getRequestURI().split("/")).toList();
        Map<String,String> getMap = request.getParameterMap().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> Arrays.toString(entry.getValue())));
        Map<String,String> headers = Collections.list(request.getHeaderNames()).stream().collect(Collectors.toMap(h -> h, request::getHeader));
        String urlOrigen = request.getRemoteAddr();

        ControllerObject controllerObject = new ControllerObject(path,getMap,headers,urlOrigen);
        return controllerObject;
    }

    @GetMapping(value={"/","one"})
    public String entryOne(){
        return "Entry one";
    }
}
