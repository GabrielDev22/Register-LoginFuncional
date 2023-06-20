package com.securidad20.securidadMaster.service;

import com.securidad20.securidadMaster.model.Contacto;

import java.util.List;

public interface ContactoService {


    List<Contacto> getAllContactos();

    Contacto getContactoById(Integer id);

    Contacto createContacto(Contacto contacto);

    Contacto updateContacto(Contacto contacto);

    void deleteContactoById(Integer id);


}
