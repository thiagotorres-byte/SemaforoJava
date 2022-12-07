package br.com.arduino.service;

import br.com.arduino.DTO.CadastroArduinoRequest;
import br.com.arduino.DTO.CadastroArduinoResponse;
import br.com.arduino.feign.TrafficManagerClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Log4j2
public class ArduinoService {

    @Autowired
    Environment environment;

    private final TrafficManagerClient client;

    public ArduinoService(TrafficManagerClient client) {
        this.client = client;
    }

    @Scheduled(initialDelay = 1000, fixedDelay=Long.MAX_VALUE)
    public void chamaArduino() throws InterruptedException {

        Random random = new Random();

        String port = environment.getProperty("local.server.port");

        CadastroArduinoRequest jsonRequest = CadastroArduinoRequest
                .builder()
                .identificador("2")
                .identificadorSemaforoPrincipal("1")
                .tempoInverso(random.nextBoolean())
                .build();

        log.info("criando semaforo: {}", jsonRequest.toString());
        CadastroArduinoResponse novosTempos = client.criarSemaforo(jsonRequest, port);
        log.info("retorno semaforo: {}", novosTempos.toString());

        while (true) {

            log.info("Luz vermelha apagada");

            log.info("Luz verde ligada");

            Thread.sleep(novosTempos.getTempoVerde());

            log.info("Luz verde apagada");

            log.info("Luz amarela ligada");

            Thread.sleep(novosTempos.getTempoAmarelo());

            log.info("Luz amarela apagada");

            log.info("Luz vermelha ligada");

            Thread.sleep(novosTempos.getTempoVermelho());

//            client.cameraSemaforoTemCarro(false)

            if (true){
                client.adicionaSegundos(jsonRequest.getIdentificador(), 10000);
                Thread.sleep(10000);
            }
        }
    }
}
