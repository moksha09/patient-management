package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getId().toString());
        patientResponseDTO.setAddress(patient.getAddress());
        patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setName(patient.getName());

        return patientResponseDTO;

    }

    public static Patient toModel(PatientRequestDTO requestDTO){
        Patient patient = new Patient();
        patient.setName(requestDTO.getName());
        patient.setAddress(requestDTO.getAddress());
        patient.setEmail(requestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(requestDTO.getDateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(requestDTO.getRegisteredDate()));
        return patient;
    }
}
