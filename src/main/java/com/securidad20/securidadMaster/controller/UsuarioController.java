package com.securidad20.securidadMaster.controller;

import com.securidad20.securidadMaster.model.Contacto;
import com.securidad20.securidadMaster.model.Usuario;
import com.securidad20.securidadMaster.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(" http://127.0.0.1:5173/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/getAll")
    public List<Usuario> getAllUsuarios(){
        if(usuarioService.getAllUsuarios() == null){
            return null;
        }
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/get/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        if(usuarioService.getUsuarioById(id) == null){
            return null;
        }
        return usuarioService.getUsuarioById(id);
    }
    @PostMapping("/create")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        if(usuarioService.createUsuario(usuario) == null){
            return null;
        }
        return usuarioService.createUsuario(usuario);
    }

    @PutMapping("/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        if(usuarioService.updateUsuario(usuario) == null){
            return null;
        }
        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuarioById(@PathVariable Integer id) { usuarioService.deleteUsuarioById(id);}

}
