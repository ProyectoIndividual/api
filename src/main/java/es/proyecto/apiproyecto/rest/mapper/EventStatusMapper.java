package es.proyecto.apiproyecto.rest.mapper;

import es.proyecto.apiproyecto.repository.modelo.Event;
import es.proyecto.apiproyecto.repository.modelo.EventStatus;
import es.proyecto.apiproyecto.rest.dto.EventDTO;
import es.proyecto.apiproyecto.rest.dto.EventStatusDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventStatusMapper {

    public static EventStatusDTO map(EventStatus eventStatus){
        if (eventStatus == null) return null;

      EventStatusDTO eventStatusDTO=new EventStatusDTO();
      eventStatusDTO.setId(eventStatus.getId());
      eventStatusDTO.setEvent(EventMapper.map(eventStatus.getEvent()));
      eventStatusDTO.setTimeAssigned(eventStatus.getTimeAssigned());
      eventStatusDTO.setEnd(eventStatus.isEnd());
      return eventStatusDTO;
    }


    public static EventStatusDTO map(Optional<EventStatus> eventStatus){

        if (eventStatus.isEmpty())return null;

        return EventStatusMapper.map(eventStatus.get());

    }



    public static List<EventStatusDTO> map(List<EventStatus> events){

        if (events == null) return null;
        if (events.isEmpty())return  null;

        return events.stream().map(x -> EventStatusMapper.map(x)).collect(Collectors.toList());

    }



    public static EventStatus map(EventStatusDTO eventStatusDTO) {

        if (eventStatusDTO == null) return  null;

        EventStatus eventStatus=new EventStatus();
        eventStatus.setId(eventStatusDTO.getId());
        eventStatus.setEvent(EventMapper.map(eventStatusDTO.getEvent()));
        eventStatus.setTimeAssigned(eventStatusDTO.getTimeAssigned());
        eventStatus.setEnd(eventStatusDTO.isEnd());


        return eventStatus;
    }


}
