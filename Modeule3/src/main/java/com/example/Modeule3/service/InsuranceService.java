package com.example.Modeule3.service;

import org.springframework.stereotype.Service;

import com.example.Modeule3.entities.Insurance;
import com.example.Modeule3.entities.Patient2;
import com.example.Modeule3.repositories.InsuranceRepo;
import com.example.Modeule3.repositories.PatientRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceService {

	private final InsuranceRepo insuranceRepo;
	
	private final PatientRepo patientRepo;

	@Transactional
	public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
		Patient2 patient=patientRepo.findById(patientId).orElseThrow();
		patient.setInsurance(insurance);//dirtied the patient
		insurance.setPatient(patient); //optional
		return insurance;
	} 
	
	@Transactional
	public Insurance updateInsuranceOfAPatient(Insurance insurance, Long patientId) {
		Patient2 patient=patientRepo.findById(patientId).orElseThrow();
		patient.setInsurance(insurance);//dirtied the patient
		insurance.setPatient(patient); //optional	
		return insurance;
	} 
	
	@Transactional
	public Patient2 removeInsuranceOfAPatient(Long patientId) {
		Patient2 patient=patientRepo.findById(patientId).orElseThrow();
		patient.setInsurance(null);//dirtied the patient
		
		return patient;
	} 
	
	
	
}
