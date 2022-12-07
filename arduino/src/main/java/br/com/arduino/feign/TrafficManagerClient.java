package br.com.arduino.feign;

import br.com.arduino.DTO.CadastroArduinoRequest;
import br.com.arduino.DTO.CadastroArduinoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="trafficManager", url = "http://localhost:8080")
public interface TrafficManagerClient {

    @PostMapping("/semaforo/{port}")
    CadastroArduinoResponse criarSemaforo (@RequestBody CadastroArduinoRequest request, @PathVariable String port);

    @GetMapping("/semaforo/{identificador}")
    CadastroArduinoResponse pegarSemaforo (@PathVariable String identificador);

    @GetMapping("/camera/{trueOuFalse}")
    Boolean cameraSemaforoTemCarro(@PathVariable Boolean trueOuFalse);

}
