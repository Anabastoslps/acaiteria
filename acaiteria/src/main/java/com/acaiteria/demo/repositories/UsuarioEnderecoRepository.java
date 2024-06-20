package com.acaiteria.demo.repositories;

import com.acaiteria.demo.Models.UsuarioEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEnderecoRepository extends JpaRepository<UsuarioEndereco, Long> {
}
