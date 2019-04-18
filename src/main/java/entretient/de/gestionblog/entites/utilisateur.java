package entretient.de.gestionblog.entites;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;
@Entity
@DiscriminatorValue("User")

public class utilisateur extends AppUser{
    public utilisateur() {
    }

    public utilisateur(String nom, String prenom, String username, String password, String confirmPasssword, List<AppRole> roles, List<Commentaire> listCom, List<Posts> listPost) {
        super(nom, prenom, username, password, confirmPasssword, roles, listCom, listPost);
    }
}
