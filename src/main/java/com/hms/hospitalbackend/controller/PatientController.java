package com.hms.hospitalbackend.controller;

import com.hms.hospitalbackend.entity.Patient;
import com.hms.hospitalbackend.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service){
        this.service = service;
    }

    @GetMapping
    public List<Patient> getAll(){
        return service.getAllPatients();
    }

    @PostMapping
    public Patient save(
            @RequestBody Patient patient
    ){
        return service.savePatient(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ){
        service.deletePatient(id);
    }
}