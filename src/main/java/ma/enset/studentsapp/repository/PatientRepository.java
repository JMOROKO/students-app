package ma.enset.studentsapp.repository;

import ma.enset.studentsapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNom(String nom);
    List<Patient> findByNomContaining(String nom);
    @Query("from Patient p WHERE p.nom LIKE :nom")
    List<Patient> search(String nom);
}
