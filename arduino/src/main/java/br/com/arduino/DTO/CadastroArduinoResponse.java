package br.com.arduino.DTO;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class CadastroArduinoResponse {

    private String identificador;

    private long tempoVermelho;

    private long tempoAmarelo;

    private long tempoVerde;

    private Status status;

}
