package ma.enset.studentsapp.services;

import ma.enset.studentsapp.entities.Consultation;
import ma.enset.studentsapp.entities.Medecin;
import ma.enset.studentsapp.entities.Patient;
import ma.enset.studentsapp.entities.RendezVous;

import java.util.List;
import java.util.Optional;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    // /!\ pourquoi ici vous avez préféré passé l'objet rendez-vous plutot que passer le patient et le medecin en parametre ?
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

    Optional<Patient> findPatientById(Long id);
    Optional<Medecin> findMedecinById(Long id);

    List<Patient> findAllPatient();
}
