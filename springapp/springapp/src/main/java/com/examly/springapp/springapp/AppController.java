package com.examly.springapp.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;  
import java.util.*;
@RestController
public class AppController {
    @Autowired
    Dao dao;
    @PostMapping("/saveTask")
    public String saveTask(@RequestBody Model detail) {
        dao.save(detail);
        return "Sucess";
    }
    @GetMapping("/allTasks")
    List<Model> allTasks()
    {
        List<Model> all=(List<Model>) dao.findAll();
        return all;
    }
    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam int  id)
    {
        dao.deleteById(id);
    }
    @GetMapping("/getTask")
    public Model getTask(@RequestParam int id){
        Model a =dao.findById(id).orElse(null);
        return a;
    }
}