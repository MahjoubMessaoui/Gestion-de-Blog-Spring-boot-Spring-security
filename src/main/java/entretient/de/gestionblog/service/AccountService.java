package entretient.de.gestionblog.service;


import entretient.de.gestionblog.entites.AppRole;
import entretient.de.gestionblog.entites.AppUser;
import entretient.de.gestionblog.entites.Reducteur;
import entretient.de.gestionblog.entites.utilisateur;

public interface AccountService {
    utilisateur saveUser(String nom, String prenom, String username, String password, String confirmedPassword);
    Reducteur saveReducteur(String nom, String prenom, String username, String password, String confirmedPassword);

    AppRole save(AppRole role);
     AppUser loadUserByUsername(String username);
     void addRoleToUser(String username, String rolename);
}
