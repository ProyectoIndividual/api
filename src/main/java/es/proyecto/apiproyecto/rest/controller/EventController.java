package es.proyecto.apiproyecto.rest.controller;

import es.proyecto.apiproyecto.repository.modelo.Event;
import es.proyecto.apiproyecto.rest.dto.EventDTO;
import es.proyecto.apiproyecto.rest.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

    @Autowired
    EventService eventService;


    @GetMapping("/count")
    public Long count(){
        return this.eventService.count();
    }

    @GetMapping(value = "")
    public List<EventDTO> findAll(@RequestParam(required = false, defaultValue = "false")String search){
        return this.eventService.findAll( search);

    }

    @GetMapping(value = "/{id}")
    public EventDTO findById(@PathVariable Integer id){

        EventDTO eventDTO= this.eventService.findById(id);


        if (eventDTO == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento no fue encontrado");
        }

        return eventDTO;
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public EventDTO create(@RequestBody EventDTO eventDTO){

        return this.eventService.create(eventDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Event actualizado")
    public void update(@RequestBody EventDTO eventDTO){

        this.eventService.update(eventDTO);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Evento eliminado")
    public void delete(EventDTO eventDTO){

        this.eventService.delete(eventDTO);
    }
}
