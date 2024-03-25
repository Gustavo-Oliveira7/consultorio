package com.gustavo.consultorio.models.repositories;

import com.gustavo.consultorio.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "select * from clients where cpf = ?1 ", nativeQuery = true)
    Client findByCpf(String cpf);
}
