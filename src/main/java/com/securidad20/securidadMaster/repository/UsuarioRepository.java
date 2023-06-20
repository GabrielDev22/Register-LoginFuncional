package com.securidad20.securidadMaster.repository;


import com.securidad20.securidadMaster.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

     Optional<Usuario> findOneByEmail(String email);

}
