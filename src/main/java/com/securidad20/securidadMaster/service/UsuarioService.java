package com.securidad20.securidadMaster.service;

import com.securidad20.securidadMaster.model.Contacto;
import com.securidad20.securidadMaster.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();

    Usuario getUsuarioById(Integer id);
    Usuario createUsuario(Usuario usuario);

    Usuario updateUsuario(Usuario usuario);

    void deleteUsuarioById(Integer id);



}
