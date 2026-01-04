package com.example.Modeule3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Modeule3.entities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

}
