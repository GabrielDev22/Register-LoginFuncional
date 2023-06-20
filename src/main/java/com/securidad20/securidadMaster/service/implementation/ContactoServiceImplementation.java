package com.securidad20.securidadMaster.service.implementation;

import com.securidad20.securidadMaster.model.Contacto;
import com.securidad20.securidadMaster.repository.ContactoRepository;
import com.securidad20.securidadMaster.service.ContactoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class ContactoServiceImplementation implements ContactoService {


    private final ContactoRepository contactoRepository;

    public ContactoServiceImplementation(ContactoRepository contactoRepository) {this.contactoRepository = contactoRepository;}


    @Override
    public List<Contacto> getAllContactos(){
        List<Contacto> allContacto = null;
        try{
            log.info("Empezando el getAllContactos");
            allContacto = contactoRepository.findAll();
            if(allContacto.isEmpty()){
                log.error("No se encontro ningun contacto");
                return null;
            }
            log.info("Terminando el getAllContacto");
            return allContacto;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return allContacto;
    }

    @Override
    public Contacto getContactoById(Integer id){
        Contacto particularContacto = null;
        try{
            log.info("Empezando el getContactoById");
            particularContacto = contactoRepository.getReferenceById(id);
            if(particularContacto.getId() == null){
                log.error("No se encontro ningun Contacto con ese ID");
                return null;
            }

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return particularContacto;
    }


    @Override
    public Contacto createContacto(Contacto contacto){
        Contacto createContacto = null;
        try{
            log.info("Empezando la creacion del usuario nuevo");
            if(!StringUtils.hasText(contacto.getEmail()) || contacto.getNombre() == null || contacto.getCelular() == null){
                log.info("No se creo ningun contacto");
                return null;
            }
            createContacto = contactoRepository.save(contacto);
            log.info("Terminando la creacion del nuevo usuario");
            return createContacto;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return createContacto;
    }

    @Override
    public Contacto updateContacto(Contacto contacto){
        Contacto updateContacto = null;
        try{
            log.info("Empezando el udpateContacto");
            if(!StringUtils.hasText(contacto.getNombre()) || contacto.getId() == null || contacto.getEmail() == null || contacto.getCelular() == null){
                log.error("Falto algun dato para actualizar");
                return null;
            }
            updateContacto = contactoRepository.save(contacto);
            log.info("Terminando el updateContacto");
            return updateContacto;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return updateContacto;
    }

    @Override
    public void deleteContactoById(Integer id){
        log.info("Empezando la eliminacion del Contacto");
        contactoRepository.deleteById(id);
        log.info("Finalizando la eliminacion del Contacto");
    }

}
