package es.proyecto.apiproyecto.rest.mapper;

import es.proyecto.apiproyecto.repository.modelo.Event;
import es.proyecto.apiproyecto.repository.modelo.Invitation;
import es.proyecto.apiproyecto.repository.modelo.User;
import es.proyecto.apiproyecto.rest.dto.EventDTO;
import es.proyecto.apiproyecto.rest.dto.InvitationDTO;
import es.proyecto.apiproyecto.rest.dto.UserDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserMapper {
    //Traduce un objeto Users(JPA) a UsersDTO
    public static UserDTO map(User user, boolean conTodo){
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurnames(user.getSurnames());
        userDTO.setEmail(user.getEmail());
        userDTO.setDescription(user.getDescription());
        userDTO.setPhone(user.getPhone());
        userDTO.setImage(user.getImage());
        userDTO.setPassword(user.getPassword());
        userDTO.setLocalitation(LocalitationMapper.map(user.getLocalitation()));
        userDTO.setToken(user.getToken());
        userDTO.setRegistrationDate(user.getRegistrationDate());


        if (!conTodo) return userDTO;

        //Añadimos campo Events Invitations


/*
        List<Event> events = user.getEvents();
        List<Invitation> invitations = user.getInvitations();

        if (events.isEmpty()) return userDTO;

        List<EventDTO> eventsDTO = events.stream().map(x->EventMapper.map(x)).collect(Collectors.toList());
        userDTO.setEvents(eventsDTO);

        if (invitations.isEmpty())return userDTO;

        List<InvitationDTO> invitationsDto= invitations.stream().map(x->InvitationMapper.map(x)).collect(Collectors.toList());
        userDTO.setInvitations(invitationsDto);*/

        return userDTO;
    }

    //Trauce Optional<Users> a un UsersDTO
    public static UserDTO map(Optional<User> user, boolean conTodo){

        if (user.isEmpty())return null;

        return UserMapper.map(user.get(),conTodo);

    }

    //Traduce una lista de UsersJPA a una lista de UsersDTO

    public static List<UserDTO> map(List<User> users, boolean conTodo){

        if (users == null) return null;
        if (users.isEmpty())return  null;

        return users.stream().map(x -> UserMapper.map(x,conTodo)).collect(Collectors.toList());

    }

    //Traduce un usersDTO a un usersJPA

    public static User map(UserDTO userDTO, boolean conTodo) {

        if (userDTO == null) return  null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurnames(userDTO.getSurnames());
        user.setEmail(userDTO.getEmail());
        user.setDescription(userDTO.getDescription());
        user.setLocalitation(LocalitationMapper.map(userDTO.getLocalitation()));
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setToken(userDTO.getToken());
        user.setRegistrationDate(userDTO.getRegistrationDate());
        user.setImage(userDTO.getImage());
        if (!conTodo) return user;

      /*  //Añadir campo Events i invitations
        List<EventDTO> eventDTOS = userDTO.getEvents();
        List<InvitationDTO> invitationDTOS = userDTO.getInvitations();

        if (eventDTOS.isEmpty()) return user;

        List<Event> events = eventDTOS.stream().map(x->EventMapper.map(x)).collect(Collectors.toList());
        user.setEvents(events);

        if (invitationDTOS.isEmpty())return user;

        List<Invitation> invitations= invitationDTOS.stream().map(x->InvitationMapper.map(x)).collect(Collectors.toList());
        user.setInvitations(invitations);*/

        return user;
    }

}
