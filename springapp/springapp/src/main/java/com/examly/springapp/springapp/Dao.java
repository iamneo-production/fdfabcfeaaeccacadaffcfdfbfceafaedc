package com.examly.springapp.springapp;
import org.springframework.data.repository.CrudRepository;
 interface Dao extends CrudRepository<Model,Integer> {
    
}