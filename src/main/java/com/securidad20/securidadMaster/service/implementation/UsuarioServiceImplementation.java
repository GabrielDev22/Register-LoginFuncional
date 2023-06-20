package com.securidad20.securidadMaster.service.implementation;

import com.securidad20.securidadMaster.model.Contacto;
import com.securidad20.securidadMaster.model.Usuario;
import com.securidad20.securidadMaster.repository.UsuarioRepository;
import com.securidad20.securidadMaster.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class UsuarioServiceImplementation implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImplementation(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> getAllUsuarios(){
        List<Usuario> allUsuario = null;
        try{
            log.info("Empezando el getAllUsuarios");
            allUsuario = usuarioRepository.findAll();
            if(allUsuario.isEmpty()){
                log.error("No se encontro ningun usuario");
                return null;
            }
            log.info("Terminando el getAllUsuario");
            return allUsuario;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return allUsuario;
    }

    public Usuario getUsuarioById(Integer id){
        Usuario particularUsuario = null;
        try{
            log.info("Empezando getUsuarioById");
            particularUsuario = usuarioRepository.getReferenceById(id);
            if(particularUsuario.getId() == null){
                log.error("No se encontro ningun Usuario por Id");
                return null;
            }
            log.info("Terminando getUsuarioById");
            return particularUsuario;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return particularUsuario;
    }

    @Override
    public Usuario createUsuario(Usuario usuario){
        Usuario createUsuario  = null;
        try{
            log.info("Empezando el createUsuario");
            if(!StringUtils.hasText(usuario.getEmail())){
                log.info("No creo ningun contacto");
                return null;
            }
            createUsuario = usuarioRepository.save(usuario);
            log.info("Terminando createUsuario");
            return createUsuario;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return createUsuario;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario){
        Usuario updateUsuario = null;
        try{
            log.info("Empezando el updateUsuario");
            if(!StringUtils.hasText(usuario.getEmail())){
                log.error("Falto algun dato para actualizar");
                return null;
            }
            updateUsuario = usuarioRepository.save(usuario);
            log.info("Terminando el updateUsuario");
            return updateUsuario;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return updateUsuario;
    }

    @Override
    public void deleteUsuarioById(Integer id){
        log.info("Empezando la eliminacion del Usuario");
        usuarioRepository.deleteById(id);
        log.info("Finalizando la eliminacion del Usuario");
    }

}
