package com.gustavo.consultorio.controller;


import com.gustavo.consultorio.dto.DoctorDto;
import com.gustavo.consultorio.models.entities.Doctor;
import com.gustavo.consultorio.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
