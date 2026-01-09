package com.example.Module4.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter


public class AuditibleEntity {

	 @CreatedDate
	 @Column(nullable=false,updatable=false)
	 private LocalDateTime createdDate;
	 
	 
	 @LastModifiedDate
	 private LocalDateTime updatedDate;
	 
	 @CreatedBy
	 private String createdBy;
	 
	 
	 @LastModifiedBy
	 private String updatedBy;
	 
}
