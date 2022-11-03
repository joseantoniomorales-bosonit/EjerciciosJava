package com.bosonit.ejercicioCompetitivo2.controllers;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerObject {
    private List<String> path;
    private Map<String,String> getMap;
    private Map<String,String> headers;
    private String urlOrigen;

    public ControllerObject(List<String> path, Map<String, String> getMap, Map<String, String> headers, String urlOrigen) {
        this.path = path;
        this.getMap = getMap;
        this.headers = headers;
        this.urlOrigen = urlOrigen;
    }

    public ControllerObject(){

    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public Map<String, String> getGetMap() {
        return getMap;
    }

    public void setGetMap(Map<String, String> getMap) {
        this.getMap = getMap;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getUrlOrigen() {
        return urlOrigen;
    }

    public void setUrlOrigen(String urlOrigen) {
        this.urlOrigen = urlOrigen;
    }

    @Override
    public String toString() {
        return "ControllerObject{" +
                "path=" + path +
                ", getMap=" + getMap +
                ", headers=" + headers +
                ", urlOrigen='" + urlOrigen + '\'' +
                '}';
    }
}
