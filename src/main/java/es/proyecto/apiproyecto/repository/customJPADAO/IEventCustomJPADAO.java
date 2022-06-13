package es.proyecto.apiproyecto.repository.customJPADAO;

import es.proyecto.apiproyecto.repository.modelo.Event;

import java.util.List;

public interface IEventCustomJPADAO {

    List<Event> findAllConTodo(String search);

}
