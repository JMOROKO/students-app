package ma.enset.studentsapp.repository;

import ma.enset.studentsapp.entities.RendezVous;
import ma.enset.studentsapp.entities.StatusRDV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
    List<RendezVous> findByDate(Date date);
    List<RendezVous> findByStatus(StatusRDV status);
}
