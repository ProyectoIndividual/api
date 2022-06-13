package es.proyecto.apiproyecto.rest.controller;

import es.proyecto.apiproyecto.repository.modelo.EventStatus;
import es.proyecto.apiproyecto.rest.dto.EventStatusDTO;
import es.proyecto.apiproyecto.rest.service.EventStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/eventStatus")
@CrossOrigin
public class EventStatusController {

    @Autowired
    EventStatusService eventStatusService;


    @GetMapping("/count")
    public Long count(){
        return this.eventStatusService.count();
    }

    @GetMapping(value = "")
    public List<EventStatusDTO> findAll( @RequestParam(required = false, defaultValue = "false")String search){
        return this.eventStatusService.findAll( search);

    }

    @GetMapping(value = "/{id}")
    public EventStatusDTO findById(@PathVariable Integer id){

        EventStatusDTO eventStatusDTO = this.eventStatusService.findById(id);


        if (eventStatusDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EventStatus no fue encontrado");
        }

        return eventStatusDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public EventStatusDTO create(@RequestBody EventStatusDTO eventStatusDTO){

        return this.eventStatusService.create(eventStatusDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "EventStatus actualizado")
    public void update(@RequestBody EventStatusDTO eventStatusDTO){

        this.eventStatusService.update(eventStatusDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "EventStaus eliminado")
    public void delete(@RequestBody EventStatusDTO eventStatusDTO){

        this.eventStatusService.delete(eventStatusDTO);
    }
}
