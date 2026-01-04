package com.example.Modeule3;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Modeule3.entities.Insurance;
import com.example.Modeule3.service.InsuranceService;
import com.example.Modeule3.service.PatientService;

@SpringBootTest
public class InsuranceTest {

	@Autowired
	private InsuranceService insuranceSerivice;
	
	@Autowired
	private PatientService patientService;
	
	@Test
	public void testAssignInsuranceToPatient() {
		Insurance insurance=Insurance.builder()
				.provider("HDFC Ergo")
				.policyNumber("HDFC_236")
				.validUntil(LocalDate.of(2030, 1,1))
				.build();
		
		
	var updatedInsurance= insuranceSerivice.assignInsuranceToPatient(insurance, 1L);
	System.out.println(updatedInsurance);
//	patientService.deletePatient(1L);
	var patient=insuranceSerivice.removeInsuranceOfAPatient(1L);
	System.out.println(patient);
	
	}
}
