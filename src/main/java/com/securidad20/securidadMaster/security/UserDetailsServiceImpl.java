package com.securidad20.securidadMaster.security;

import com.securidad20.securidadMaster.controller.UsuarioController;
import com.securidad20.securidadMaster.model.Usuario;
import com.securidad20.securidadMaster.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private UsuarioController usuarioController;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository
                .findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email" + username + "no existe"));

        return new UserDetailsImpl(usuario);

    }

}
