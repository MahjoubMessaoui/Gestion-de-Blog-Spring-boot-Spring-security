package entretient.de.gestionblog.controller;


import entretient.de.gestionblog.dao.PostsRepository;
import entretient.de.gestionblog.entites.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/posts")
 @RestController
public class PostsController  {
    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("")
    public String homme(){
        return "HELLO POSTS";
    }

    @GetMapping("/all")
    public List<Posts> getallPosts(){
        return postsRepository.findAll();
    }

    @PostMapping("/add")

    public Posts addposts(@RequestBody Posts posts){
        return postsRepository.saveAndFlush(posts);
    }

    @GetMapping("/ById")
    public Posts getById(Long ref){
        return postsRepository.getOne(ref);
    }
    @PutMapping("/update")
    public Posts updateposts(@RequestBody Posts posts, Long ref){
        posts.setRef(ref);
        return postsRepository.saveAndFlush(posts);
    }

    @DeleteMapping("/remove")
    public String deletePosts(Long ref){
        try{
            postsRepository.deleteById(ref);
            return "ok";
        }
        catch (Exception e){
            return "nooooooooooo";
        }
    }




}
