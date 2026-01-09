package com.example.Module4.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


//@EntityListeners(AuditingEntityListener.class)
public class PostEntity extends AuditibleEntity {
     @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 private String title;
	 private String description;
 
//	 @CreatedDate
//	 @Column(nullable=false,updatable=false)
//	 private LocalDateTime createdDate;
//	 
//	 
//	 @LastModifiedDate
//	 private LocalDateTime updatedDate;
//	 
//	 @CreatedBy
//	 private String createdBy;
//	 
//	 
//	 @LastModifiedBy
//	 private String updatedBy;
	 
	 
	 
	 
	 
	
}
