package es.proyecto.apiproyecto.repository.customJPADAO;

import es.proyecto.apiproyecto.repository.modelo.User;

import java.util.List;

public interface IUserCustomJPDAO {

    List<User> findAllConTodo(String search);
}
