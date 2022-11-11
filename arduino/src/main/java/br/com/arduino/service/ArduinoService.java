package br.com.arduino.service;

import br.com.arduino.DTO.CadastroArduinoRequest;
import br.com.arduino.DTO.CadastroArduinoResponse;
import br.com.arduino.feign.TrafficManagerClient;
import org.springframework.stereotype.Service;

@Service
public class ArduinoService {

    public static void main(String[] args) throws InterruptedException {

        TrafficManagerClient client;

        String nomeSemaforo;

        String url = "http://localhost:8080/semaforo";

        String urlNovosTempos = "http://localhost:8080/tempoSemaforo/";

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

            if (get("http://localhost:8080/camera")){
                novosTempos = client.pegarSemaforo(jsonRequest.getIdentificador());
            }

        }
    }
}
