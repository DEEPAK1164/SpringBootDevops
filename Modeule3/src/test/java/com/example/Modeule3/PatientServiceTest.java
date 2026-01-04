package com.example.Modeule3;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Modeule3.entities.Patient2;
import com.example.Modeule3.repositories.PatientRepo;

@SpringBootTest
public class PatientServiceTest {

	@Autowired
	private PatientRepo patientRepo;
	
	@Test
	public void testPatient() {
		
//		List<Patient2>patientList=patientRepo.findAll();// N+1 problem
		List<Patient2>patientList=patientRepo.getAllPatientsWithAppointments();//Query optimization by writing custom jpql query
		for(var p:patientList) {
			System.out.println(p);
		}
	}
	
	
}
