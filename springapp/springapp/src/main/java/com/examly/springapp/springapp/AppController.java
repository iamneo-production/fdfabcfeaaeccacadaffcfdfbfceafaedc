package com.examly.springapp.springapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private Model detail;
    
    @PostMapping("/saveTask")
    public String saveTask(@RequestBody Model detail) {
        this.detail = detail;
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