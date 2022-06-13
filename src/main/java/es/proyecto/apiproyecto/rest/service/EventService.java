package es.proyecto.apiproyecto.rest.service;

import es.proyecto.apiproyecto.repository.customJPADAO.EventCustomJPADAO;
import es.proyecto.apiproyecto.repository.customJPADAO.IEventCustomJPADAO;
import es.proyecto.apiproyecto.repository.jpa.IEventJPADAO;
import es.proyecto.apiproyecto.repository.modelo.Event;

import es.proyecto.apiproyecto.rest.dto.EventDTO;

import es.proyecto.apiproyecto.rest.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    IEventJPADAO iEventJPADAO;


    @Autowired
    IEventCustomJPADAO iEventCustomJPADAO;

    public Long count(){
        return this.iEventJPADAO.count();
    }

    public List<EventDTO> findAll( String search){

        List<Event> events = new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
            events = this.iEventJPADAO.findAll();
        }else{
            events = this.iEventCustomJPADAO.findAllConTodo(search);
        }

        return EventMapper.map(events);

    }

     public EventDTO findById(Integer id){

        Optional<Event> event = this.iEventJPADAO.findById(id);

        return EventMapper.map(event);
    }

    public EventDTO create(EventDTO eventDTO){

        Event event = EventMapper.map(eventDTO);
        event = this.iEventJPADAO.save(event);

        return EventMapper.map(event);
    }

    public void update(EventDTO eventDTO){

        Event event = EventMapper.map(eventDTO);
        this.iEventJPADAO.save(event);

    }

    public void delete(EventDTO eventDTO){
        Event event = EventMapper.map(eventDTO);
        this.iEventJPADAO.delete(event);
    }
}
