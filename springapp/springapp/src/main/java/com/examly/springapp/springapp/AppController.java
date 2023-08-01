package com.examly.springapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
@RestController
public class AppController {
    @Autowired
    Dao dao;
    private List<Model> all=(List<Model>) dao.findAll();
    @PostMapping("/saveTask")
    public String saveTask(@RequestBody Model detail) {
        dao.save(detail);
        return "Sucess";
    }
    @GetMapping("/alltasks")
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
    public ResponseEntity<Model> getTask(@RequestParam("id") Integer id){
        Model a =dao.findById(id).orElse(null);
        return ResponseEntity.ok(a);
}


}