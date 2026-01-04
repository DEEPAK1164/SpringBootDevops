package com.example.Modeule3.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,length=100)
	private String name;
	
	@Column(length=100)
	private String specialization;
	@Column(nullable=false,length=100)
	private String email;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@OneToMany(mappedBy="doctor")//inverse side
	private Set<Appointment>appointments=new HashSet<>();
}
