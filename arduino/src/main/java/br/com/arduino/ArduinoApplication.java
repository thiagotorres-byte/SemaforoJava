package br.com.arduino;

import br.com.arduino.service.ArduinoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ArduinoApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ArduinoApplication.class, args);
		ArduinoService arduino = new ArduinoService();
		arduino.chamaArduino();
	}
}
