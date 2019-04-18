package entretient.de.gestionblog.dao;

import entretient.de.gestionblog.entites.AppUser;
import entretient.de.gestionblog.entites.Reducteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ReducteurRepository  extends JpaRepository<Reducteur,Long> {
  //  Reducteur findByUsername(String username);

}
