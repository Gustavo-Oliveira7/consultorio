package com.gustavo.consultorio.dto;

public record DoctorDto(String name,
                        String gender,
                        String specialization,
                        String birthDate,
                        String cpf) {
}
