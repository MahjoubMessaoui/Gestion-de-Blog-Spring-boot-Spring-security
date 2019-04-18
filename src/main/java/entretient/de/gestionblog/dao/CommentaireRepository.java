package entretient.de.gestionblog.dao;

import entretient.de.gestionblog.entites.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

}
