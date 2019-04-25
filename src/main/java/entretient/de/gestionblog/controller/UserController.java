package entretient.de.gestionblog.controller;


import entretient.de.gestionblog.dao.AppUserRepository;


import entretient.de.gestionblog.dao.ReducteurRepository;
import entretient.de.gestionblog.entites.AppUser;

import entretient.de.gestionblog.entites.utilisateur;
import entretient.de.gestionblog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private AccountService accountService;
    @GetMapping("")
    public String homme(){
        return "hello user";
    }

   @GetMapping("/all")
    public List<AppUser> getallutilisateur(){
       return  appUserRepository.findAll();
    }

    @PostMapping("/add")

    public utilisateur adduser(@RequestBody utilisateur user)
    {
        return accountService.saveUser(user.getNom(),user.getPrenom(),
                user.getUsername(),user.getPassword(),user.getConfirmPasssword());
    }

    @GetMapping("/ById")
    public AppUser getById(Long id){

        return appUserRepository.getOne(id);
    }
    @PutMapping("/update")
    public AppUser updateUser(@RequestBody utilisateur user, Long id){
        user.setId(id);
        return appUserRepository.saveAndFlush(user);
    }

    @DeleteMapping("/remove")
    public String deletuser(Long id){
        try{
            appUserRepository.deleteById(id);
            return "ok";
        }
        catch (Exception e){
            return "nooooooooooo";
        }
    }
}
