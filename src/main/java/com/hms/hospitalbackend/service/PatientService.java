package com.hms.hospitalbackend.service;

import com.hms.hospitalbackend.entity.Patient;
import com.hms.hospitalbackend.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    // SAVE PATIENT
    public Patient savePatient(Patient patient)
    {
        return patientRepository.save(patient);
    }


    // GET ALL PATIENTS
    public List<Patient> getAllPatients()
    {
        return patientRepository.findAll();
    }


    // DELETE PATIENT
    public void deletePatient(Long id)
    {
        patientRepository.deleteById(id);
    }


    // UPDATE PATIENT
    public Patient updatePatient(
            Long id,
            Patient updatedPatient)
    {

        Patient patient =
                patientRepository
                        .findById(id)
                        .orElseThrow();

        patient.setName(
                updatedPatient.getName());

        patient.setAge(
                updatedPatient.getAge());

        patient.setGender(
                updatedPatient.getGender());

        patient.setPhone(
                updatedPatient.getPhone());

        return patientRepository.save(patient);

    }

}