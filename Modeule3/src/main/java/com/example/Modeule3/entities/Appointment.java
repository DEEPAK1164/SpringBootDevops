package com.example.Modeule3.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"patient", "doctor"})
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDateTime appointmentTime;
	

	@Column(length=500)
private String reason;

private String status;



@ManyToOne(fetch = FetchType.LAZY)   // 👈 LAZY
@JoinColumn(nullable = false)
private Patient2 patient;

@ManyToOne(fetch = FetchType.LAZY)   // 👈 LAZY
@JoinColumn(nullable = false)
private Doctor doctor;
	
	
}
