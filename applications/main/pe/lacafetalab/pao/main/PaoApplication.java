package pe.lacafetalab.pao.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(basePackages = { "pe.lacafetalab.pao.**" })
@EnableJpaRepositories(basePackages = { "pe.lacafetalab.pao.**" })
@EntityScan("pe.lacafetalab.pao.**")
public class PaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaoApplication.class, args);
	}
	
	@PostConstruct
	public void init(){
		// Setting Spring Boot SetTimeZone
		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
	}
}
