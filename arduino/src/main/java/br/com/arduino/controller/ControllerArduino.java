package br.com.arduino.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerArduino {

    @GetMapping
    public ResponseEntity<Boolean> healthCheck(){
        return ResponseEntity.ok(true);
    }

}
