package entretient.de.gestionblog.entites;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roleName ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AppRole(String roleName) {
        this.roleName = roleName;
    }

    public AppRole() {
    }
}
