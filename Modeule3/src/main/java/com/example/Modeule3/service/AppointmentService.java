package com.example.Modeule3.service;

import org.springframework.stereotype.Service;

import com.example.Modeule3.entities.Appointment;
import com.example.Modeule3.entities.Doctor;
import com.example.Modeule3.entities.Patient2;
import com.example.Modeule3.repositories.AppointmentRepo;
import com.example.Modeule3.repositories.DoctorRepo;
import com.example.Modeule3.repositories.PatientRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {
  
	private final AppointmentRepo appointmentRepo;
	private final DoctorRepo doctorRepo;
	private final PatientRepo patientRepo;
	
	
	@Transactional
	public Appointment createNewAppointment(
	        Appointment appointment,
	        Long doctorId,
	        Long patientId
	) {
	    Doctor doctor = doctorRepo.findById(doctorId)
	            .orElseThrow(() -> new RuntimeException("Doctor not found"));

	    Patient2 patient = patientRepo.findById(patientId)
	            .orElseThrow(() -> new RuntimeException("Patient not found"));

	    appointment.setDoctor(doctor);
	    appointment.setPatient(patient);

	    return appointmentRepo.save(appointment); // ✅ REQUIRED
	}

}
