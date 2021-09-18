package org.essaadani.patientservice;

import lombok.RequiredArgsConstructor;
import org.essaadani.patientservice.dto.PatientRequestDTO;
import org.essaadani.patientservice.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class PatientServiceApplication {
    private final PatientService patientService;

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args -> {
            patientService.save(new PatientRequestDTO("Patient1", new Date("02/05/1990"), "medecin1"));
            patientService.save(new PatientRequestDTO("Patient1", new Date("25/03/1985"), "medecin2"));
            patientService.save(new PatientRequestDTO("Patient1", new Date("02/01/1995"), "medecin3"));
        };
    }
}
