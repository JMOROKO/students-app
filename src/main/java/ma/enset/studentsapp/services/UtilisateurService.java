package ma.enset.studentsapp.services;

import ma.enset.studentsapp.entities.Role;
import ma.enset.studentsapp.entities.Utilisateur;

public interface UtilisateurService {
    Utilisateur saveUser(Utilisateur utilisateur);
    Role saveRole(Role role);
    Utilisateur findUtilisateurByUsername(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUtilisateur(String username, String roleName);

    Utilisateur authenticate(String username, String password);
}
