package es.proyecto.apiproyecto.rest.controller;

import es.proyecto.apiproyecto.repository.modelo.Localitation;
import es.proyecto.apiproyecto.rest.dto.LocalitationDTO;
import es.proyecto.apiproyecto.rest.service.LocalitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/localitation")
@CrossOrigin
public class LocalitationController {

    @Autowired
    LocalitationService localitationService;

    @GetMapping("/count")
    public Long count(){
        return this.localitationService.count();
    }

    @GetMapping(value = "")
    public List<LocalitationDTO> findAll(@RequestParam(required = false, defaultValue = "false")String search){
        return this.localitationService.findAll( search);

    }

    @GetMapping(value = "/{id}")
    public LocalitationDTO findById(@PathVariable Integer id){

        LocalitationDTO localitationDTO = this.localitationService.findById(id);


        if (localitationDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Localitation no fue encontrado");
        }

        return localitationDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public LocalitationDTO create(@RequestBody LocalitationDTO localitationDTO){

        return this.localitationService.create(localitationDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Localitation actualizado")
    public void update(@RequestBody LocalitationDTO localitationDTO){

        this.localitationService.update(localitationDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Localitation eliminado")
    public void delete(@RequestBody LocalitationDTO localitationDTO){

        this.localitationService.delete(localitationDTO);
    }
}
