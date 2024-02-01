package com.example.consultorio.controller;


import com.example.consultorio.models.entities.Doctor;
import com.example.consultorio.models.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository repository;
    @GetMapping
    public List<Doctor> getAll(){
        List<Doctor> doctorList = repository.findAll();
        return doctorList;
    }
}
