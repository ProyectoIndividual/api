package es.proyecto.apiproyecto.rest.service;

import es.proyecto.apiproyecto.repository.customJPADAO.IInvitationCustomJPADAO;
import es.proyecto.apiproyecto.repository.jpa.IInvitationJPADAO;
import es.proyecto.apiproyecto.repository.modelo.Invitation;
import es.proyecto.apiproyecto.rest.dto.InvitationDTO;
import es.proyecto.apiproyecto.rest.mapper.InvitationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvitationService {

    @Autowired
    IInvitationJPADAO iInvitationJPADAO;

    @Autowired
    IInvitationCustomJPADAO iInvitationCustomJPADAO;

    public Long count(){
        return this.iInvitationJPADAO.count();
    }

    public List<InvitationDTO> findAll( String search){

        List<Invitation> invitations = new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
            invitations = this.iInvitationJPADAO.findAll();
        }else{
           invitations = this.iInvitationCustomJPADAO.findAllConTodo(search);
        }

        return InvitationMapper.map(invitations);

    }

    public InvitationDTO findById(Integer id){

        Optional<Invitation> invitation = this.iInvitationJPADAO.findById(id);

        return InvitationMapper.map(invitation);
    }

    public InvitationDTO create(InvitationDTO invitationDTO){

        Invitation invitation = InvitationMapper.map(invitationDTO);
        invitation = this.iInvitationJPADAO.save(invitation);

        return InvitationMapper.map(invitation);
    }

    public void update(InvitationDTO invitationDTO){

        Invitation invitation= InvitationMapper.map(invitationDTO);
        this.iInvitationJPADAO.save(invitation);

    }

    public void delete(InvitationDTO invitationDTO){
        Invitation invitation = InvitationMapper.map(invitationDTO);
        this.iInvitationJPADAO.delete(invitation);
    }

}
