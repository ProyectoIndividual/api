package es.proyecto.apiproyecto.rest.controller;

import es.proyecto.apiproyecto.repository.modelo.Invitation;
import es.proyecto.apiproyecto.rest.dto.InvitationDTO;
import es.proyecto.apiproyecto.rest.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/invitation")
@CrossOrigin
public class InvitationController {

    @Autowired
    InvitationService invitationService;


    @GetMapping("/count")
    public Long count(){
        return this.invitationService.count();
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InvitationDTO> findAll( @RequestParam(required = false, defaultValue = "false")String search){
        return this.invitationService.findAll( search);

    }

    @GetMapping(value = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public InvitationDTO findById(@PathVariable Integer id){

       InvitationDTO invitationDTO = this.invitationService.findById(id);


        if (invitationDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invitacion no fue encontrado");
        }

        return invitationDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public InvitationDTO create(@RequestBody InvitationDTO invitationDTO){

        return this.invitationService.create(invitationDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Usuario actualizado")
    public void update(@RequestBody  InvitationDTO invitationDTO){

        this.invitationService.update(invitationDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Usuario eliminado")
    public void delete(@RequestBody InvitationDTO invitationDTO){

        this.invitationService.delete(invitationDTO);
    }
}
