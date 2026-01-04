package com.example.Modeule3;


import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Modeule3.entities.Appointment;

import com.example.Modeule3.service.AppointmentService;
import com.example.Modeule3.service.PatientService;


@SpringBootTest
public class AppointmentTest {

	

	@Autowired
	private AppointmentService appointmentService;
	

	@Autowired
	private PatientService patientService;
	
	@Test
	public void testCreateNewAppointment() {
		Appointment appointment=Appointment.builder()
				.appointmentTime(LocalDateTime.of(2026, 2,1,14,0,0))
				.reason("Weight Gain")
				.status("pending")
				.build();
	var updatedAppointment=	appointmentService.createNewAppointment(appointment, 2L, 5L);
	System.out.println(updatedAppointment);
	patientService.deletePatient(5L);
}
	}
