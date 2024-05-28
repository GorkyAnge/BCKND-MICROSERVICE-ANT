package com.example.puntos.PuntosLicencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/puntos")
public class PuntosLicenciaController {

	PuntosLicenciaService service;
	
	@Autowired
	public PuntosLicenciaController(PuntosLicenciaService service) {
        this.service = service;
    }
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<String> getPuntosLicencia(@PathVariable("id")String cedula){
		return service.getPuntosLicencia(cedula);
	}
}
