package com.sriman.vaccinationschedulesystem.Patient;

import com.sriman.vaccinationschedulesystem.Vaccination.Vaccination;
import com.sriman.vaccinationschedulesystem.Vaccination.VaccinationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PatientController {

    @Autowired
    private PatientJpaRepository patientJpaRepository;

    @Autowired
    private VaccinationJpaRepository vaccinationJpaRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientJpaRepository.findAll();
    }

    @PostMapping("/patients")
    public ResponseEntity<Object> addPatient(@RequestBody Patient patient){
        Patient savedPatient = patientJpaRepository.save(patient);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}")
                .buildAndExpand(savedPatient.getName()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/patients/{id}/vaccine")
    public ResponseEntity<Object> addVaccine(@PathVariable int id,@RequestBody Vaccination vaccination){
        Patient patient = patientJpaRepository.getById(id);
        vaccination.setPatient(patient);
        vaccinationJpaRepository.save(vaccination);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(vaccination.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


}
