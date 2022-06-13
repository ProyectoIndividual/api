package es.proyecto.apiproyecto.repository.jpa;

import es.proyecto.apiproyecto.repository.modelo.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventStatusJPADAO extends JpaRepository<EventStatus,Integer> {
}
