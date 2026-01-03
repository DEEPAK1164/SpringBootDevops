package com.example.Modeule3.dto;

import com.example.Modeule3.entities.BloodGroupType;

import lombok.Data;

@Data
public class BloodGroupStats {
private final BloodGroupType bloodGroupType;
private final Long count;
}
