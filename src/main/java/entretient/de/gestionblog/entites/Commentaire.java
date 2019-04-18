package entretient.de.gestionblog.entites;

import javax.persistence.*;

@Entity
public class Commentaire  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne(fetch = FetchType .LAZY)
    private AppUser appUser  ;
    @ManyToOne(fetch = FetchType.LAZY)
    private Posts posts;

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Commentaire(String message, AppUser appUser, Posts posts) {
        this.message = message;
        this.appUser = appUser;
        this.posts = posts;
    }

    public Commentaire() {
    }



    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
