package entretient.de.gestionblog.dao;

import entretient.de.gestionblog.entites.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
