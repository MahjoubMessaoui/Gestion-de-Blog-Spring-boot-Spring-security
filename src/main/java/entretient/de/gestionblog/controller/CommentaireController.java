package entretient.de.gestionblog.controller;


import entretient.de.gestionblog.dao.CommentaireRepository;
import entretient.de.gestionblog.entites.Commentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")

public class CommentaireController {
    @Autowired

    private CommentaireRepository commentaireRepository;
    @GetMapping("")
    public String homme(){
        return "HELLO commentaire";
    }

    @GetMapping("/all")
    public List<Commentaire> gettcommentaire(){

        return commentaireRepository.findAll();
    }

    @PostMapping("/add")

    public Commentaire addcommentaire(@RequestBody Commentaire commentaire){
        return commentaireRepository.saveAndFlush(commentaire);
    }

    @GetMapping("/ById")
    public Commentaire getById(Long id){
        return commentaireRepository.getOne(id);
    }
    @PutMapping("/update")
    public Commentaire updatecommentaire(@RequestBody Commentaire commentaire , Long id){
        commentaire.setId(id);
        return commentaireRepository.saveAndFlush(commentaire);
    }

    @DeleteMapping("/remove")
    public String deleteCommentaire(Long id){
        try{
            commentaireRepository.deleteById(id);
            return "ok";
        }
        catch (Exception e){
            return "nooooooooooo";
        }
    }
}
