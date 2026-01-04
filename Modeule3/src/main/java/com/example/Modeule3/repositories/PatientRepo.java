package com.example.Modeule3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Modeule3.entities.Patient2;

public interface PatientRepo extends JpaRepository<Patient2,Long> {
 
	
	@Query("select p from Patient2 p LEFT JOIN FETCH p.appointments")
	List<Patient2>getAllPatientsWithAppointments();
}
