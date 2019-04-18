package entretient.de.gestionblog.dao;

import entretient.de.gestionblog.entites.AppUser;

import entretient.de.gestionblog.entites.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<utilisateur,Long> {

}
