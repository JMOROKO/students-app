package ma.enset.studentsapp;

import ma.enset.studentsapp.entities.*;
import ma.enset.studentsapp.repository.ConsultationRepository;
import ma.enset.studentsapp.repository.MedecinRepository;
import ma.enset.studentsapp.repository.PatientRepository;
import ma.enset.studentsapp.repository.RendezVousRepository;
import ma.enset.studentsapp.services.IHospitalService;
import ma.enset.studentsapp.services.UtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            IHospitalService service,
            UtilisateurService utilisateurService
    ){
        return args -> {
            //creation de trois patients
            Stream.of("Moroko jean", "Moroko Franck", "Moroko jean-renaud")
                .forEach(nom -> {
                    Patient patient = Patient.builder()
                            .nom(nom)
                            .dateNaissance(new Date())
                            .malade(false)
                            .score(10)
                            .build();
                    service.savePatient(patient);
                });
            //creation de trois médecins
            Stream.of("KOFFI OLO", "Hamza", "Morar")
                    .forEach(nom -> {
                        Medecin medecin = Medecin.builder()
                                .nom(nom)
                                .specialite(Math.random()>0.5?"Dentiste":"Cardio")
                                .email(nom.replace(" ", "-")+"@gmail.com")
                                .build();
                        service.saveMedecin(medecin);
                    });

            //recherche d'un patient
            Patient patient = service.findPatientById(1L).orElse(null);
            // /!\ il y a un probleme lorsqu'on essaie d'afficher un patient recherché

            //recherche d'un medecin
            Medecin medecin = service.findMedecinById(Long.valueOf(2)).orElse(null);

            //creation d'un rendez-vous
            RendezVous rendezVous = RendezVous.builder()
                    .medecin(medecin)
                    .patient(patient)
                    .date(new Date())
                    .status(StatusRDV.PENDING)
                    .build();
            service.saveRendezVous(rendezVous);

            Consultation consultation = Consultation.builder()
                    .dateConsultation(new Date())
                    .rendezVous(rendezVous)
                    .build();
            service.saveConsultation(consultation);

            Utilisateur utilisateur = Utilisateur.builder()
                    .name("user1")
                    .password("123456")
                    .build();
            Utilisateur utilisateur2 = Utilisateur.builder()
                    .name("admin")
                    .password("123456")
                    .build();
            utilisateurService.saveUser(utilisateur);
            utilisateurService.saveUser(utilisateur2);

            Stream.of("STUDENT", "ADMIN")
                .forEach(roleName -> {
                    Role role = Role.builder()
                            .roleName(roleName)
                            .build();
                    utilisateurService.saveRole(role);
                });

            utilisateurService.addRoleToUtilisateur("user1", "STUDENT");
            utilisateurService.addRoleToUtilisateur("admin", "ADMIN");

            try{
                Utilisateur userAuth = utilisateurService.authenticate("user1", "123456");
                System.out.println(userAuth.getName());
                userAuth.getRoles().forEach(r -> {
                    System.out.println(r);
                });
            }
            catch(Exception e){
                new RuntimeException(e);
            }
        };
    }

}
