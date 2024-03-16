package ma.enset.studentsapp.repository;

import ma.enset.studentsapp.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Optional<Medecin> findByEmail(String email);
    List<Medecin> findByNom(String nom);
    List<Medecin> findByNomContaining(String nom);
    List<Medecin> findBySpecialite(String specialite);
}
