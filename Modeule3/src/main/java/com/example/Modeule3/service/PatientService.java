package com.example.Modeule3.service;

import org.springframework.stereotype.Service;

import com.example.Modeule3.entities.Patient;
import com.example.Modeule3.repositories.PatientRepo;
import com.example.Modeule3.repositories.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
	
private final PatientRepository patientRepository;

private final PatientRepo patientRepo;
	

@Transactional
public void testPatientTransaction() {
Patient p1=patientRepository.findById(161L).orElseThrow();
Patient p2=patientRepository.findById(161L).orElseThrow();
System.out.println(p1+" "+p2);
System.out.println(p1==p2);

p1.setName("Random Name");
}
	

@Transactional
public void deletePatient(Long patientid) {
    patientRepo.findById(patientid).orElseThrow();
	patientRepo.deleteById(patientid);
}
}
