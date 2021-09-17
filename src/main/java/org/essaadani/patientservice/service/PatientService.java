package org.essaadani.patientservice.service;

import org.essaadani.patientservice.dto.PatientRequestDTO;
import org.essaadani.patientservice.dto.PatientResponseDTO;

import java.util.List;

public interface PatientService {
    List<PatientResponseDTO> getAllPatients();
    PatientResponseDTO getPatientById(String id);
    PatientResponseDTO update(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO save(PatientRequestDTO patientRequestDTO);
    void delete(String id);
}
