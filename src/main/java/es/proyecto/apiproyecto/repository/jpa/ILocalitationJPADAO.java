package es.proyecto.apiproyecto.repository.jpa;

import es.proyecto.apiproyecto.repository.modelo.Localitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocalitationJPADAO extends JpaRepository<Localitation,Integer> {
}
