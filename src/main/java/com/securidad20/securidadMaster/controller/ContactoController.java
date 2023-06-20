package com.securidad20.securidadMaster.controller;

import com.securidad20.securidadMaster.model.Contacto;
import com.securidad20.securidadMaster.repository.ContactoRepository;
import com.securidad20.securidadMaster.service.ContactoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contactos")
@CrossOrigin(" http://127.0.0.1:5173/")
public class ContactoController {

    /* private final ContactoRepository contactoRepository; */
    private final ContactoService contactoService;

    public ContactoController(ContactoService contactoService)  {this.contactoService = contactoService;}

    /* @GetMapping
    public List<Contacto> listContacto() {return contactoRepository.findAll();} */

    @GetMapping("/getAll")
    public List<Contacto> getAllContacto(){
        if(contactoService.getAllContactos() == null){
            return null;
        }
        return contactoService.getAllContactos();
    }

    @GetMapping("/get/{id}")
    public Contacto getContactoById(@PathVariable Integer id){
        if(contactoService.getContactoById(id) == null){
            return null;
        }
        return contactoService.getContactoById(id);
    }
    @PostMapping("/create")
    public Contacto createContacto(@RequestBody Contacto contacto){
        if(contactoService.createContacto(contacto) == null){
            return null;
        }
        return contactoService.createContacto(contacto);
    }

    @PutMapping("/update")
    public Contacto updateContacto(@RequestBody Contacto contacto){
        if(contactoService.updateContacto(contacto) == null){
            return null;
        }
        return contactoService.updateContacto(contacto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAnimeById(@PathVariable Integer id) {contactoService.deleteContactoById(id);}
}
