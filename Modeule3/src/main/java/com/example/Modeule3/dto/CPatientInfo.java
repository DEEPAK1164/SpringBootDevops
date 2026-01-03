package com.example.Modeule3.dto;

import lombok.Data;

@Data // POJO CLASS
public class CPatientInfo {
	
// by adding final keyword it creates required and no args constructor with using the annotation
 final private Long id;
 final private String name;
 
}
