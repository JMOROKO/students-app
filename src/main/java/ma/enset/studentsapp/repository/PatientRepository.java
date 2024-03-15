package ma.enset.studentsapp.repository;

import ma.enset.studentsapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByNom(String nom);
    List<Patient> findByNomContaining(String nom);
    @Query("from Patient p WHERE p.nom LIKE :nom")
    List<Patient> search(String nom);
}
