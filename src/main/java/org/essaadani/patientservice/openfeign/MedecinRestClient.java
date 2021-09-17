package org.essaadani.patientservice.openfeign;

import org.essaadani.patientservice.models.Medecin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MEDECIN-SERVICE")
public interface MedecinRestClient {
    @GetMapping("/api/medecins/{id}")
    Medecin getMedecin(@PathVariable(name="id") String id);
}
