package es.proyecto.apiproyecto.rest.service;

import es.proyecto.apiproyecto.repository.jpa.ILocalitationJPADAO;
import es.proyecto.apiproyecto.repository.modelo.Localitation;
import es.proyecto.apiproyecto.rest.dto.LocalitationDTO;
import es.proyecto.apiproyecto.rest.mapper.LocalitationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocalitationService {

    @Autowired
    ILocalitationJPADAO iLocalitationJPADAO;

    public Long count(){
        return this.iLocalitationJPADAO.count();
    }


    public List<LocalitationDTO> findAll(String search){

        List<Localitation> localitations = new ArrayList<>();

        if (search.equalsIgnoreCase("false")){
           localitations = this.iLocalitationJPADAO.findAll();
        }else{
          //  localitations = this.iChatsCustomJPADAO.findAllSearch(search);
        }

        return LocalitationMapper.map(localitations);

    }

    public LocalitationDTO findById(Integer id){

        Optional<Localitation> localitation = this.iLocalitationJPADAO.findById(id);

        return LocalitationMapper.map(localitation);
    }

    public LocalitationDTO create(LocalitationDTO localitationDTO){

        Localitation localitation = LocalitationMapper.map(localitationDTO);
        localitation = this.iLocalitationJPADAO.save(localitation);

        return LocalitationMapper.map(localitation);
    }

    public void update(LocalitationDTO localitationDTO){

        Localitation localitation = LocalitationMapper.map(localitationDTO);
        this.iLocalitationJPADAO.save(localitation);

    }

    public void delete(LocalitationDTO localitationDTO){
        Localitation localitation = LocalitationMapper.map(localitationDTO);
        this.iLocalitationJPADAO.delete(localitation);
    }
}
