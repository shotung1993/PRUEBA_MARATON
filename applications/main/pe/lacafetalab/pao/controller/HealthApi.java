package pe.lacafetalab.pao.controller;

import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.lacafetalab.pao.shared.response.RestResponse;

@RestController
@RequestMapping("/")
public class HealthApi {

	static Logger logger = Logger.getLogger(HealthApi.class.getName());

	@GetMapping("/health")
	public ResponseEntity<RestResponse> getHealthy() {
		return ResponseEntity.ok(new RestResponse(true, 200, 200, "OK", new Object()));
	}
}
