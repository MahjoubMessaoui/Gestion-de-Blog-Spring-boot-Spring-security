package entretient.de.gestionblog.entites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Posts implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ref;
    private String entreprise;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date_publiee;
    @Temporal(TemporalType.DATE)
    private Date date_depots;
    private String type_post;
    private int nb_posts;
    private String disponibilite;
    private String etude;
    private String mail;

    public Posts(String entreprise, String description, Date date_publiee, Date date_depots, String type_post, int nb_posts, String disponibilite, String etude, String mail) {
        this.entreprise = entreprise;
        this.description = description;
        this.date_publiee = date_publiee;
        this.date_depots = date_depots;
        this.type_post = type_post;
        this.nb_posts = nb_posts;
        this.disponibilite = disponibilite;
        this.etude = etude;
        this.mail = mail;

    }

    @ManyToOne(fetch = FetchType .LAZY)
        private AppUser appUser ;
      @OneToMany(fetch = FetchType.LAZY)
    List<Commentaire>  ListCom =new ArrayList<>();

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public long getRef() {
        return ref;
    }

    public void setRef(long ref) {
        this.ref = ref;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_publiee() {
        return date_publiee;
    }

    public void setDate_publiee(Date date_publiee) {
        this.date_publiee = date_publiee;
    }

    public Date getDate_depots() {
        return date_depots;
    }

    public void setDate_depots(Date date_depots) {
        this.date_depots = date_depots;
    }

    public String getType_post() {
        return type_post;
    }

    public void setType_post(String type_post) {
        this.type_post = type_post;
    }

    public int getNb_posts() {
        return nb_posts;
    }

    public void setNb_posts(int nb_posts) {
        this.nb_posts = nb_posts;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getEtude() {
        return etude;
    }

    public void setEtude(String etude) {
        this.etude = etude;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Posts() {
    }

















}
