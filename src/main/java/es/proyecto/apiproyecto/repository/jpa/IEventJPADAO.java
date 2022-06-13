package es.proyecto.apiproyecto.repository.jpa;

import es.proyecto.apiproyecto.repository.modelo.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventJPADAO extends JpaRepository<Event,Integer> {
}
