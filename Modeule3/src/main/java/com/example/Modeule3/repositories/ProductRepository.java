package com.example.Modeule3.repositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Modeule3.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	List<Product> findByTitle(String title);

	List<Product> findByCreatedAtAfter(LocalDateTime after);
	
	@Query("select e.title from Product e where e.title=?1 and e.price=?2")
	Optional<Product>findByTitleAndPrice(String title,BigDecimal price);

	List<Product> findByOrderByPrice();

	List<Product> findBy(Sort sortBy);

	
}
