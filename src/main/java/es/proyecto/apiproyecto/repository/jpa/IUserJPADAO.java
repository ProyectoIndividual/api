package es.proyecto.apiproyecto.repository.jpa;

import es.proyecto.apiproyecto.repository.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserJPADAO extends JpaRepository<User, Integer> {
}
