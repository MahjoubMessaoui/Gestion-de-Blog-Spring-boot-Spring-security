package entretient.de.gestionblog.service;


import entretient.de.gestionblog.dao.AppRoleRepository;
import entretient.de.gestionblog.dao.AppUserRepository;

import entretient.de.gestionblog.entites.AppRole;
import entretient.de.gestionblog.entites.AppUser;
import entretient.de.gestionblog.entites.Reducteur;
import entretient.de.gestionblog.entites.utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public utilisateur saveUser(String nom, String prenom, String username, String password, String confirmedPassword) {
        AppUser user=  appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        utilisateur appUser=new utilisateur();
        appUser.setPrenom(prenom);
      appUser.setNom(nom);
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setConfirmPasssword(bCryptPasswordEncoder.encode(confirmedPassword));
        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public Reducteur saveReducteur(String nom, String prenom, String username, String password, String confirmedPassword) {
        AppUser user1=  appUserRepository.findByUsername(username);
        if(user1!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Reducteur reducteur=new Reducteur();
        reducteur.setPrenom(prenom);
        reducteur.setNom(nom);
        reducteur.setUsername(username);
        reducteur.setPassword(bCryptPasswordEncoder.encode(password));
        reducteur.setConfirmPasssword(bCryptPasswordEncoder.encode(confirmedPassword));
     appUserRepository.save(reducteur);
        addRoleToUser(username,"REDUCTEUR");
        return reducteur;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }
}
