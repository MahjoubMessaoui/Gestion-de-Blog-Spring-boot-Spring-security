package entretient.de.gestionblog.controller;


import entretient.de.gestionblog.dao.ReducteurRepository;
import entretient.de.gestionblog.entites.AppUser;
import entretient.de.gestionblog.entites.Commentaire;
import entretient.de.gestionblog.entites.Reducteur;
import entretient.de.gestionblog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reducteur")

public class ReducteurController {
    @Autowired
    private ReducteurRepository reducteurRepository;
    @Autowired
    private AccountService accountService;
    @GetMapping("")
    public String homme(){
        return "HELLO Reducteur";
    }

    @GetMapping("/all")
    public List<Reducteur> gettallreducteur(){

        return reducteurRepository.findAll();
    }

    @PostMapping("/add")

    public Reducteur addreducteur(@RequestBody Reducteur reducteur){
        return accountService.saveReducteur(reducteur.getNom(),reducteur.getPrenom(),
                reducteur.getUsername(),reducteur.getPassword(), reducteur.getConfirmPasssword());
    }

    @GetMapping("/ById")
    public Reducteur getById(Long id){
        return reducteurRepository.getOne(id);
    }
    @PutMapping("/update")
    public Reducteur updatereducteur(@RequestBody Reducteur reducteur, Long id){
        reducteurRepository.saveAndFlush(reducteur);
        return reducteurRepository.saveAndFlush(reducteur);
    }

    @DeleteMapping("/remove")
    public String deleteReducteur(Long id){
        try{
            reducteurRepository.deleteById(id);
            return "ok";
        }
        catch (Exception e){
            return "nooooooooooo";
        }
    }


}
