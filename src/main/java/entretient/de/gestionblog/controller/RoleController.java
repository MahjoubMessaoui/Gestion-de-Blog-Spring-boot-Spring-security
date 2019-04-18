package entretient.de.gestionblog.controller;


import entretient.de.gestionblog.dao.AppRoleRepository;
import entretient.de.gestionblog.entites.AppRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private AppRoleRepository appRoleRepository;

    @GetMapping("")
    public String homme(){
        return "HELLO Role";
    }

    @GetMapping("/all")
    public List<AppRole> getAppRole(){
        return appRoleRepository.findAll();
    }

    @PostMapping("/add")

    public AppRole addrole(@RequestBody AppRole appRole){
        return appRoleRepository.saveAndFlush(appRole);
    }

    @GetMapping("/ById")
    public AppRole getById(Long id){
        return appRoleRepository.getOne(id);
    }
    @GetMapping("/update")
    public AppRole updaterole(@RequestBody AppRole appRole, Long id){
        appRole.setId(id);
        return appRoleRepository.saveAndFlush(appRole);
    }

    @DeleteMapping("/remove")
    public String deletePosts(Long id){
        try{
            appRoleRepository.deleteById(id);
            return "ok";
        }
        catch (Exception e){
            return "nooooooooooo";
        }
    }

}
