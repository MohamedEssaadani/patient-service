package org.essaadani.patientservice.service;

import lombok.RequiredArgsConstructor;
import org.essaadani.patientservice.dto.PatientRequestDTO;
import org.essaadani.patientservice.dto.PatientResponseDTO;
import org.essaadani.patientservice.entities.Patient;
import org.essaadani.patientservice.exception.MedecinNotFoundException;
import org.essaadani.patientservice.mappers.PatientMapper;
import org.essaadani.patientservice.models.Medecin;
import org.essaadani.patientservice.openfeign.MedecinRestClient;
import org.essaadani.patientservice.repositories.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final MedecinRestClient medecinRestClient;

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();

        for (Patient patient : patients){
            Medecin medecin = getMedecin(patient.getMedecinID());
            patient.setMedecin(medecin);
        }

        return patients.stream()
                .map(patientMapper::toPatientResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PatientResponseDTO getPatientById(String id) {
        Patient patient = patientRepository.findById(id).get();
        patient.setMedecin(medecinRestClient.getMedecin(patient.getMedecinID()));

        return patientMapper.toPatientResponseDTO(patient);
    }

    @Override
    public PatientResponseDTO update(PatientRequestDTO patientRequestDTO) {
        Patient patient = patientMapper.toPatient(patientRequestDTO);
        Patient updatedPatient = patientRepository.save(patient);
        PatientResponseDTO patientResponseDTO = patientMapper.toPatientResponseDTO(updatedPatient);
        patientResponseDTO.setMedecin(getMedecin(updatedPatient.getMedecinID()));

        return patientResponseDTO;
    }

    @Override
    public PatientResponseDTO save(PatientRequestDTO patientRequestDTO) {
        Medecin medecin = getMedecin(patientRequestDTO.getMedecinID());

        Patient patient = patientMapper.toPatient(patientRequestDTO);
        patient.setId(UUID.randomUUID().toString());
        Patient createdPatient = patientRepository.save(patient);

        PatientResponseDTO patientResponseDTO = patientMapper.toPatientResponseDTO(createdPatient);
        patientResponseDTO.setMedecin(medecin);
        return patientResponseDTO;
    }

    private Medecin getMedecin(String medecinID) {
        try{
            return medecinRestClient.getMedecin(medecinID);
        }catch (Exception ex){
            throw new MedecinNotFoundException("Medecin Not Found!");
        }
    }

    @Override
    public void delete(String id) {
        patientRepository.deleteById(id);
    }
}
