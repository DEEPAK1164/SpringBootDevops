package com.example.Modeule3.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private LocalDateTime appointmentTime;
	

	@Column(length=500)
private String reason;

private String status;


@ManyToOne //owning side
@JoinColumn(nullable=false)
private Patient2 patient;


@ManyToOne //owning side
@JoinColumn(nullable=false)
private Doctor doctor;
	
	
}
