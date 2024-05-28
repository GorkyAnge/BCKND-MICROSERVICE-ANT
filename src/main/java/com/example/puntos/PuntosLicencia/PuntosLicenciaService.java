package com.example.puntos.PuntosLicencia;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PuntosLicenciaService {

	public  ResponseEntity<String> getPuntosLicencia(String cedula) {

		String url = "https://consultaweb.ant.gob.ec/PortalWEB/paginas/clientes/clp_grid_citaciones.jsp?ps_tipo_identificacion=CED&ps_identificacion="
				+ cedula + "&ps_placa=";
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject(url, String.class);
		Document doc = Jsoup.parse(response);
		String extractedData = "";
		String text = doc.body().text();
		String searchString = "Puntos: ";
		int index = text.indexOf(searchString);
		if (index != -1) {
			int startIndex = index + searchString.length();
			int endIndex = text.indexOf(" ", startIndex);
			if (endIndex != -1) {
				extractedData = text.substring(startIndex, endIndex);
			} else {
				extractedData = text.substring(startIndex);
			}
		}
		return ResponseEntity.ok(extractedData);
	}
}
