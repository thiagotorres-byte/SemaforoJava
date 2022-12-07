package br.com.arduino;

import br.com.arduino.feign.TrafficManagerClient;
import br.com.arduino.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;


@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class ArduinoApplication {


	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ArduinoApplication.class, args);
	}
}
