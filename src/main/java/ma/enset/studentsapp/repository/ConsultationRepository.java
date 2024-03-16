package ma.enset.studentsapp.repository;

import ma.enset.studentsapp.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByDateConsultation(Date date);
}
