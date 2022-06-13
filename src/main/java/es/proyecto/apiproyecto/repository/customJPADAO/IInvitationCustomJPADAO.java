package es.proyecto.apiproyecto.repository.customJPADAO;

import es.proyecto.apiproyecto.repository.modelo.Invitation;


import java.util.List;

public interface IInvitationCustomJPADAO {
    List<Invitation> findAllConTodo(String search);

}
