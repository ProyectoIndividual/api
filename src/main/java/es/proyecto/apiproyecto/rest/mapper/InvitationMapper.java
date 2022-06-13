package es.proyecto.apiproyecto.rest.mapper;

import es.proyecto.apiproyecto.repository.modelo.Invitation;
import es.proyecto.apiproyecto.repository.modelo.Localitation;
import es.proyecto.apiproyecto.rest.dto.InvitationDTO;
import es.proyecto.apiproyecto.rest.dto.LocalitationDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvitationMapper {

    public static InvitationDTO map(Invitation invitation){
        if (invitation == null) return null;

        InvitationDTO invitationDTO = new InvitationDTO();
        invitationDTO.setId(invitation.getId());
        invitationDTO.setUser(UserMapper.map(invitation.getUser(),false));
        invitationDTO.setEvent(EventMapper.map(invitation.getEvent()));
        invitationDTO.setInvoiceAmount(invitation.getInvoiceAmount());
        invitationDTO.setDiscounet(invitation.getDiscounet());
        invitationDTO.setTotalAmount(invitation.getTotalAmount());
        invitationDTO.setAccept(invitation.isAccept());
        return invitationDTO;
    }


    public static InvitationDTO map(Optional<Invitation> invitation){

        if (invitation.isEmpty())return null;

        return InvitationMapper.map(invitation.get());

    }



    public static List<InvitationDTO> map(List<Invitation> invitations){

        if (invitations == null) return null;
        if (invitations.isEmpty())return  null;

        return invitations.stream().map(x -> InvitationMapper.map(x)).collect(Collectors.toList());

    }



    public static Invitation map(InvitationDTO invitationDTO) {

        if (invitationDTO == null) return  null;

        Invitation invitation = new Invitation();
        invitation.setId(invitationDTO.getId());
        invitation.setUser(UserMapper.map(invitationDTO.getUser(),false));
        invitation.setEvent(EventMapper.map(invitationDTO.getEvent()));
        invitation.setInvoiceAmount(invitationDTO.getInvoiceAmount());
        invitation.setDiscounet(invitationDTO.getDiscounet());
        invitation.setTotalAmount(invitationDTO.getTotalAmount());
        invitation.setAccept(invitationDTO.isAccept());


        return invitation;
    }

}
