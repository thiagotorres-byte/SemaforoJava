package br.com.arduino.DTO;

import lombok.*;

@Getter
@Builder
@Data
public class CadastroArduinoRequest {
    private String identificador;
    private String identificadorSemaforoPrincipal;
    private Boolean tempoInverso;
}
