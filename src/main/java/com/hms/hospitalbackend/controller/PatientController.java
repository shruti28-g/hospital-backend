package com.hms.hospitalbackend.controller;

import com.hms.hospitalbackend.entity.Patient;
import com.hms.hospitalbackend.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {

    @Autowired
    private PatientService patientService;


    // SAVE PATIENT
    @PostMapping
    public Patient savePatient(
            @RequestBody Patient patient)
    {

        return patientService
                .savePatient(patient);

    }


    // GET ALL PATIENTS
    @GetMapping
    public List<Patient> getAllPatients()
    {

        return patientService
                .getAllPatients();

    }


    // DELETE PATIENT
    @DeleteMapping("/{id}")

    public String deletePatient(
            @PathVariable Long id)
    {

        patientService
                .deletePatient(id);

        return "Patient deleted successfully";

    }


    // UPDATE PATIENT
    @PutMapping("/{id}")

    public Patient updatePatient(

            @PathVariable Long id,

            @RequestBody
            Patient patient)
    {

        return patientService
                .updatePatient(
                        id,
                        patient);

    }

}