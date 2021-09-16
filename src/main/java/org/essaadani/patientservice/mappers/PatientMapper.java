package org.essaadani.patientservice.mappers;

import org.essaadani.patientservice.dto.PatientRequestDTO;
import org.essaadani.patientservice.dto.PatientResponseDTO;
import org.essaadani.patientservice.entities.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient patientRequestDTOToPatient(PatientRequestDTO patientRequestDTO);
    PatientResponseDTO patientToPatientResponseDTO(Patient patient);
}
