package es.proyecto.apiproyecto.repository.customJPADAO;

import es.proyecto.apiproyecto.repository.modelo.Localitation;

import java.util.List;

public interface ILocalitationCustomJPADAO {

    List<Localitation> findAllConTodo(String search);
}
