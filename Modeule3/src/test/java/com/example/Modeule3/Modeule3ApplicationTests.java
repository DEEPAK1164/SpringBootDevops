package com.example.Modeule3;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Modeule3.dto.BloodGroupStats;
import com.example.Modeule3.dto.CPatientInfo;
import com.example.Modeule3.dto.PatientInfo;
import com.example.Modeule3.entities.Patient;
import com.example.Modeule3.entities.Product;
import com.example.Modeule3.repositories.PatientRepository;
import com.example.Modeule3.repositories.ProductRepository;
import com.example.Modeule3.service.PatientService;


@SpringBootTest
//@Disabled("Disabled until DB setup is fixed")
class Modeule3ApplicationTests {

	@Autowired 
	ProductRepository productRepository;
	@Autowired 
	PatientRepository patientRepository;
	
	@Autowired
	private PatientService patientService;
	
	
	@Test
	void contextLoads() {
		
	}
    
	@Test
	void createRepository() {
		productRepository.deleteAll();
		Product product=Product.builder()
				.sku("Nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(123)
				.build();
		
		Product savedProduct=productRepository.save(product);
		System.out.println(savedProduct);
	}
//	
	@Test
	void getRepository() {
		List<Product> products=productRepository.findAll();
		System.out.println(products);
	}

	@Test
	void getByTitleRepository() {
		List<Product> products=productRepository.findByTitle("Nestle Chocolate");
		System.out.println(products);
	}
	
	@Test
	void getProductAfterCreatedRepository() {
		List<Product> products=productRepository.findByCreatedAtAfter(LocalDateTime.of(2026, 1, 1, 15, 0));
		System.out.println(products);
	}
	
	@Test
	void getProductByTitleAndPriceRepository() {
		Optional<Product> product=productRepository.findByTitleAndPrice("Nestle Chocolate",(BigDecimal.valueOf(123.45)));
		System.out.println(product);
	}
	
	
@Test
public void findAllPatietns() {
	List<Patient>patientList=patientRepository.findAll();
	System.out.println(patientList);
	for(Patient p:patientList) {
		System.out.println(p.getName());
	}
}



@Test
public void findAllIPatietns() {
	List<PatientInfo>patientList=patientRepository.getAllPatientInfo();
	System.out.println(patientList);
	for(PatientInfo p:patientList) {
		System.out.println(p.getName());
	}
	}


@Test
public void findAllCPatietns() {
	List<CPatientInfo>patientList=patientRepository.getAllPatientsInfo();
	System.out.println(patientList);
	for(CPatientInfo p:patientList) {
		System.out.println(p.getName());
	}
	}

	

@Test
public void getBloodGroupStatsTest() {
    List<BloodGroupStats> stats = patientRepository.getBloodGroupStats();
    System.out.println(stats);
    for (BloodGroupStats s : stats) {
        System.out.println(
            "Blood Group: " + s.getBloodGroupType() +
            ", Total Patients: " + s.getCount()
        );
    }
}

@Test
public void updatePatientNameTest() {

    int noOfRowsAffected =
            patientRepository.updatePatientNameWithId("Deepak Maurya", 161L);

    System.out.println("Rows affected: " + noOfRowsAffected);
}


@Test
public void testPatient() {
	
	
	patientService.testPatientTransaction();
}

}
	
	
	

