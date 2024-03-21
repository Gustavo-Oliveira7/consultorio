package com.gustavo.consultorio.service;

import com.gustavo.consultorio.models.entities.Doctor;
import com.gustavo.consultorio.models.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
