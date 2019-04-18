package entretient.de.gestionblog.entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Utlisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "roleType")
public abstract class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Column(unique = true)
    private String username ;
    private  String password ;
    private String confirmPasssword;

    @ManyToMany(fetch = FetchType.EAGER)
    List <AppRole> roles= new ArrayList<>();
    @OneToMany(fetch = FetchType .LAZY)
    List<Commentaire> ListCom= new ArrayList<>();
    @OneToMany()
    List<Posts> ListPost= new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPasssword() {
        return confirmPasssword;
    }

    public void setConfirmPasssword(String confirmPasssword) {
        this.confirmPasssword = confirmPasssword;
    }


    public List<Commentaire> getListCom() {
        return ListCom;
    }

    public void setListCom(List<Commentaire> listCom) {
        ListCom = listCom;
    }

    public List<Posts> getListPost() {
        return ListPost;
    }

    public void setListPost(List<Posts> listPost) {
        ListPost = listPost;
    }



    public List<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRole> roles) {
        this.roles = roles;
    }

    public AppUser() {
    }

    public AppUser(String nom, String prenom, String username, String password, String confirmPasssword, List<AppRole> roles, List<Commentaire> listCom, List<Posts> listPost) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.confirmPasssword = confirmPasssword;
        this.roles = roles;
        ListCom = listCom;
        ListPost = listPost;
    }

}
