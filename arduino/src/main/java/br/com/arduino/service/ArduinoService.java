package br.com.arduino.service;

import br.com.arduino.DTO.CadastroArduinoRequest;
import br.com.arduino.DTO.CadastroArduinoResponse;
import br.com.arduino.feign.TrafficManagerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArduinoService {

    @Autowired
    TrafficManagerClient client;

    public void chamaArduino() throws InterruptedException {

        String nomeSemaforo;

        CadastroArduinoRequest jsonRequest = CadastroArduinoRequest
                .builder()
                .identificador("teste")
                .identificadorSemaforoPrincipal("")
                .tempoInverso(false)
                .build();

        CadastroArduinoResponse novosTempos = client.criarSemaforo(jsonRequest);

        while (true) {

            System.out.println("Luz vermelha apagada");

            System.out.println("Luz verde ligada");

            Thread.sleep(novosTempos.getTempoVerde());

            System.out.println("Luz verde apagada");

            System.out.println("Luz amarela ligada");

            Thread.sleep(novosTempos.getTempoAmarelo());

            System.out.println("Luz amarela apagada");

            System.out.println("Luz vermelha ligada");

            Thread.sleep(novosTempos.getTempoVermelho());

            if (client.cameraSemaforoTemCarro(true)){
                Thread.sleep(10000);
            }

        }
    }
}
