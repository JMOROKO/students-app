package ma.enset.studentsapp.services;

import ma.enset.studentsapp.entities.Role;
import ma.enset.studentsapp.entities.Utilisateur;
import ma.enset.studentsapp.repository.RoleRepository;
import ma.enset.studentsapp.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService{
    private UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Utilisateur saveUser(Utilisateur utilisateur) {
        utilisateur.setId(UUID.randomUUID().toString());
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Utilisateur findUtilisateurByUsername(String username) {
        Utilisateur utilisateurRecherche = utilisateurRepository.findByName(username).orElse(null);

        try {
            if(utilisateurRecherche == null) {
                throw new Exception("L'utilisateur recherché n'existe pas.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return utilisateurRecherche;
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        Role roleRecherche = roleRepository.findByRoleName(roleName).orElse(null);
        try {
            if(roleRecherche == null) {
                throw new Exception("Le role recherché n'existe pas.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return roleRecherche;
    }

    @Override
    public void addRoleToUtilisateur(String username, String roleName) {
        Utilisateur utilisateur = findUtilisateurByUsername(username);
        Role role = findRoleByRoleName(roleName);

        if(utilisateur.getRoles() != null){
            utilisateur.getRoles().add(role);
            role.getUtilisateurs().add(utilisateur);
        }
        // pas besoin de faire un save ici car cela est fait automatiquement à la fin de la méthode puisqu'elle est transactionnel
        //utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur authenticate(String username, String password) {
        Utilisateur user = utilisateurRepository.findByName(username).orElse(null);
        try{
            if(user != null){
                if(user.getPassword().equals(password)){
                    return user;
                }
            }else{
                throw new Exception("Le username ou le mot de passe est incorrecte.");
            }
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        return user;
    }
}
