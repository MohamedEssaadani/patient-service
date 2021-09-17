package org.essaadani.patientservice.web;

import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.essaadani.patientservice.dto.PatientRequestDTO;
import org.essaadani.patientservice.dto.PatientResponseDTO;
import org.essaadani.patientservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.POST;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PatientRestController {
    private final PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDTO>> getPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientResponseDTO> getPatient(@PathVariable String id){
        return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResponseDTO> savePatient(@RequestBody PatientRequestDTO patientRequestDTO){
        return new ResponseEntity<>(patientService.save(patientRequestDTO),HttpStatus.CREATED);
    }

    @PatchMapping("/patients")
    public ResponseEntity<PatientResponseDTO> updatePatient(@RequestBody PatientRequestDTO patientRequestDTO){
        return new ResponseEntity<>(patientService.update(patientRequestDTO),HttpStatus.OK);
    }

    @DeleteMapping("/patients")
    public ResponseEntity<?> deletePatient(@PathVariable String id){
        patientService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
