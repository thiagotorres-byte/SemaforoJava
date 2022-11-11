package br.com.arduino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ArduinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArduinoApplication.class, args);

	}

}
