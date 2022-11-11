package br.com.arduino.feign;

import br.com.arduino.DTO.CadastroArduinoRequest;
import br.com.arduino.DTO.CadastroArduinoResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:8080")
public interface TrafficManagerClient {

    @PostMapping("/semaforo")
    CadastroArduinoResponse criarSemaforo (@RequestBody CadastroArduinoRequest request);

    @GetMapping("/semaforo/{identificador}")
    CadastroArduinoResponse pegarSemaforo (@PathVariable String identificador);
}
