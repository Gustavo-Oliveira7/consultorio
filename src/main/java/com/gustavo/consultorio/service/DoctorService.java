package com.gustavo.consultorio.service;

import com.gustavo.consultorio.dto.DoctorDto;
import com.gustavo.consultorio.models.entities.Doctor;
import com.gustavo.consultorio.models.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<DoctorDto> getDoctors(){
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map(doctor -> new DoctorDto(
                doctor.getName(),
                doctor.getGender(),
                doctor.getSpecialization(),
                doctor.getBirthDate()
        )).collect(Collectors.toList());
    }
}
