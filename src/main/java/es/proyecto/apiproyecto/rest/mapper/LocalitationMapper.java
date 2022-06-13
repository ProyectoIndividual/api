package es.proyecto.apiproyecto.rest.mapper;

import es.proyecto.apiproyecto.repository.modelo.Localitation;

import es.proyecto.apiproyecto.rest.dto.LocalitationDTO;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocalitationMapper {

    public static LocalitationDTO map(Localitation localitation){
        if (localitation == null) return null;

        LocalitationDTO localitationDTO = new LocalitationDTO();

        localitationDTO.setId(localitation.getId());
        localitationDTO.setPostalCode(localitation.getPostalCode());
        localitationDTO.setCityName(localitation.getCityName());
        localitationDTO.setCountry(localitation.getCountry());
        localitationDTO.setStreet(localitation.getStreet());


        return localitationDTO;
    }


    public static LocalitationDTO map(Optional<Localitation> localitation){

        if (localitation.isEmpty())return null;

        return LocalitationMapper.map(localitation.get());

    }



    public static List<LocalitationDTO> map(List<Localitation> localitations){

        if (localitations == null) return null;
        if (localitations.isEmpty())return  null;

        return localitations.stream().map(x -> LocalitationMapper.map(x)).collect(Collectors.toList());

    }



    public static Localitation map(LocalitationDTO localitationDTO) {

        if (localitationDTO == null) return  null;

        Localitation localitation = new Localitation();

        localitation.setId(localitationDTO.getId());
        localitation.setPostalCode(localitationDTO.getPostalCode());
        localitation.setCityName(localitationDTO.getCityName());
        localitation.setCountry(localitationDTO.getCountry());
        localitation.setStreet(localitationDTO.getStreet());


        return localitation;
    }

}
