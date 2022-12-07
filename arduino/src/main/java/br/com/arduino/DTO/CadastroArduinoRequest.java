package br.com.arduino.DTO;

import lombok.*;

@Getter
@Data
@Builder
public class CadastroArduinoRequest {
    private String identificador;
    private String identificadorSemaforoPrincipal;
    private Boolean tempoInverso;

    public CadastroArduinoRequest(String identificador, String identificadorSemaforoPrincipal, Boolean tempoInverso) {
        this.identificador = identificador;
        this.identificadorSemaforoPrincipal = identificadorSemaforoPrincipal;
        this.tempoInverso = tempoInverso;
    }
}
