package ma.enset.studentsapp;

import ma.enset.studentsapp.entities.Patient;
import ma.enset.studentsapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootApplication
public class StudentsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            //creation de trois patient
            Stream.of("Moroko jean", "Moroko Franck", "Moroko jean-renaud")
                .forEach(nom -> {
                    Patient patient = Patient.builder()
                            .nom(nom)
                            .dateNaissance(new Date())
                            .malade(false)
                            .score(10)
                            .build();
                    patientRepository.save(patient);
                });

            //liste des patients
            List<Patient> patients = patientRepository.findAll();
            patients.forEach(System.out::println);

            //recherche du patient ayant l'ID 1
            Patient patient = patientRepository.findById(Long.valueOf(1)).get();
            System.out.println(patient);
            //recherche du patient par son nom
            Patient patient2 = patientRepository.findByNom("Moroko Franck").get();
            System.out.println(patient2);
            //Mis à jour d'un patient
            patient2.setNom("KOFFI OLOMIDE");
            patient2.setMalade(true);
            patientRepository.save(patient2);

            //suppression du patient 3
            patientRepository.deleteById(Long.valueOf(3));

        };
    }

}
