package com.gustavo.consultorio.dto;

import com.gustavo.consultorio.models.entities.Client;

public record ClientDto(String name,
                        String cpf,
                        String birthDate,
                        String address) {

}
