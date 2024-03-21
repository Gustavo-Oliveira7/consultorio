package com.gustavo.consultorio.controller;


import com.gustavo.consultorio.dto.DoctorDto;
import com.gustavo.consultorio.models.entities.Doctor;
import com.gustavo.consultorio.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> create(@RequestBody Doctor doctor) {
        Doctor newDoctor = doctorService.create(doctor);
        DoctorDto doctorDto = new DoctorDto(newDoctor.getName(),
                newDoctor.getGender(), newDoctor.getSpecialization()
                , newDoctor.getBirthDate());
        return ResponseEntity.status(201).body(doctorDto);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors() {
        List<DoctorDto> doctors = doctorService.getDoctors();
        return ResponseEntity.status(200).body(doctors);
    }
}
