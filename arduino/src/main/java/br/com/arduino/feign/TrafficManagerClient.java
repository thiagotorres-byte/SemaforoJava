package br.com.arduino.feign;

import br.com.arduino.DTO.CadastroArduinoRequest;
import br.com.arduino.DTO.CadastroArduinoResponse;
import br.com.arduino.DTO.SemaforoOutputDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="trafficManager", url = "http://localhost:8080")
public interface TrafficManagerClient {

    @PostMapping("/semaforo/{port}")
    CadastroArduinoResponse criarSemaforo (@RequestBody CadastroArduinoRequest request, @PathVariable String port);

    @GetMapping("/semaforo/{identificador}")
    CadastroArduinoResponse pegarSemaforo (@PathVariable String identificador);

    @GetMapping("/camera/{trueOuFalse}")
    Boolean cameraSemaforoTemCarro(@PathVariable Boolean trueOuFalse);

    @PutMapping("/semaforo/{identificador}/{tempo}/")
    SemaforoOutputDTO adicionaSegundos(@PathVariable String identificador, @PathVariable int tempo);

}
