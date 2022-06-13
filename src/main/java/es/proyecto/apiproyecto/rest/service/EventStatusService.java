package es.proyecto.apiproyecto.rest.service;

import es.proyecto.apiproyecto.repository.jpa.IEventStatusJPADAO;
import es.proyecto.apiproyecto.repository.modelo.EventStatus;
import es.proyecto.apiproyecto.rest.dto.EventStatusDTO;
import es.proyecto.apiproyecto.rest.mapper.EventStatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventStatusService {

    @Autowired
    IEventStatusJPADAO iEventStatusJPADAO;

    public Long count(){
        return this.iEventStatusJPADAO.count();
    }


    public List<EventStatusDTO> findAll( String search){

        List<EventStatus> eventStatuses = new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
            eventStatuses = this.iEventStatusJPADAO.findAll();
        }else{
           // eventStatuses = this.iChatsCustomJPADAO.findAllSearch(search);
        }

        return EventStatusMapper.map(eventStatuses);

    }

    public EventStatusDTO findById(Integer id){

        Optional<EventStatus> eventStatus = this.iEventStatusJPADAO.findById(id);

        return EventStatusMapper.map(eventStatus);
    }

    public EventStatusDTO create(EventStatusDTO eventStatusDTO){

        EventStatus eventStatus = EventStatusMapper.map(eventStatusDTO);
        eventStatus = this.iEventStatusJPADAO.save(eventStatus);

        return EventStatusMapper.map(eventStatus);
    }

    public void update(EventStatusDTO eventStatusDTO){

        EventStatus eventStatus = EventStatusMapper.map(eventStatusDTO);
        this.iEventStatusJPADAO.save(eventStatus);

    }

    public void delete(EventStatusDTO eventStatusDTO){
        EventStatus eventStatus = EventStatusMapper.map(eventStatusDTO);
        this.iEventStatusJPADAO.delete(eventStatus);
    }
}
