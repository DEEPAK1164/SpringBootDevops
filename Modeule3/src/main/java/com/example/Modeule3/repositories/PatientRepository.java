package com.example.Modeule3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Modeule3.dto.BloodGroupStats;
import com.example.Modeule3.dto.CPatientInfo;
import com.example.Modeule3.dto.PatientInfo;
import com.example.Modeule3.entities.Patient;

import jakarta.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
 
	@Query("select p.id as id, p.name as name,p.email as email from Patient p")
	List<PatientInfo> getAllPatientInfo();
	
	@Query("""
		      select new com.example.Modeule3.dto.CPatientInfo(
		           p.id,
		           p.name
		       )
		       from Patient p
		       """)
		List<CPatientInfo> getAllPatientsInfo();

	@Query("""
		    select new com.example.Modeule3.dto.BloodGroupStats(
		        p.bloodGroup,
		        count(p)
		    )
		    from Patient p
		    where p.bloodGroup is not null
		    group by p.bloodGroup order by COUNT(p)
		""")
		List<BloodGroupStats> getBloodGroupStats();
	
	
	@Modifying
	@Transactional
	@Query("update Patient p set p.name = :name where p.id = :id")
	int updatePatientNameWithId(@Param("name") String name, @Param("id") long id);

	
}
