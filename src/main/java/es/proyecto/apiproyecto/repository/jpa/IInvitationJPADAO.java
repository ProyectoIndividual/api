package es.proyecto.apiproyecto.repository.jpa;

import es.proyecto.apiproyecto.repository.modelo.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInvitationJPADAO extends JpaRepository<Invitation,Integer> {
}
