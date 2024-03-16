package ma.enset.studentsapp.web;

import ma.enset.studentsapp.entities.Patient;
import ma.enset.studentsapp.services.IHospitalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    private IHospitalService service;

    public PatientController(IHospitalService service) {
        this.service = service;
    }

    @GetMapping("/patients")
    public List<Patient> findAll(){
        return service.findAllPatient();
    }
}
