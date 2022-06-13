package es.proyecto.apiproyecto.rest.mapper;

import es.proyecto.apiproyecto.repository.modelo.Event;
import es.proyecto.apiproyecto.repository.modelo.Localitation;
import es.proyecto.apiproyecto.rest.dto.EventDTO;
import es.proyecto.apiproyecto.rest.dto.LocalitationDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EventMapper {

    public static EventDTO map(Event event){
        if (event == null) return null;

      EventDTO eventDTO = new EventDTO();
      eventDTO.setId(event.getId());
      eventDTO.setLocalitation(LocalitationMapper.map(event.getLocalitation()));
      eventDTO.setUser(UserMapper.map(event.getUser(),false));
      eventDTO.setDetails(event.getDetails());
      eventDTO.setStartTimePlanned(event.getStartTimePlanned());
      eventDTO.setEndTimePlanned(event.getEndTimePlanned());
      eventDTO.setStartTimeActual(event.getStartTimeActual());
      eventDTO.setEndTimeActual(event.getEndTimeActual());
      eventDTO.setPrice(event.getPrice());
      eventDTO.setPublic(event.isPublic());
      eventDTO.setImage(event.getImage());
      return eventDTO;
    }


    public static EventDTO map(Optional<Event> event) {

        if (event.isEmpty()) return null;
        return EventMapper.map(event.get());

    }

    public static List<EventDTO> map(List<Event> events){

        if (events == null) return null;
        if (events.isEmpty())return  null;

        return events.stream().map(x -> EventMapper.map(x)).collect(Collectors.toList());

    }



    public static Event map(EventDTO eventDTO) {

        if (eventDTO == null) return  null;

        Event event = new Event();

        event.setId(eventDTO.getId());
        event.setLocalitation(LocalitationMapper.map(eventDTO.getLocalitation()));
        event.setUser(UserMapper.map(eventDTO.getUser(),false));
        event.setDetails(eventDTO.getDetails());
        event.setStartTimePlanned(eventDTO.getStartTimePlanned());
        event.setEndTimePlanned(eventDTO.getEndTimePlanned());
        event.setStartTimeActual(eventDTO.getStartTimeActual());
        event.setEndTimeActual(eventDTO.getEndTimeActual());
        event.setPrice(eventDTO.getPrice());
        event.setPublic(eventDTO.isPublic());
        event.setImage(eventDTO.getImage());


        return event;
    }


}
