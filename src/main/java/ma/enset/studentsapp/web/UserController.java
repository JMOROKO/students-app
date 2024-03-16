package ma.enset.studentsapp.web;

import jdk.jshell.execution.Util;
import lombok.AllArgsConstructor;
import ma.enset.studentsapp.entities.Utilisateur;
import ma.enset.studentsapp.services.UtilisateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateurs/{username}")
    public Utilisateur getUser(@PathVariable String username){
        Utilisateur utilisateur = utilisateurService.findUtilisateurByUsername(username);
        return utilisateur;
    }
}
