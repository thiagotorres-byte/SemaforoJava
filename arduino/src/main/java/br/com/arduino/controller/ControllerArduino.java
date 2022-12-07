package br.com.arduino.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ControllerArduino {

    @GetMapping(value = "/healthchek")
    public ResponseEntity<Boolean> healthCheck(){
        log.info("healthchek recebido");
        return ResponseEntity.ok(true);
    }

}
