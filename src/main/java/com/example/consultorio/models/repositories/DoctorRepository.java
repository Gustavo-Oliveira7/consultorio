package com.example.consultorio.models.repositories;

import com.example.consultorio.models.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
}
