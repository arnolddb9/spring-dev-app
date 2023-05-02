package com.pfcti.spring.dev.app.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/login")
@Slf4j
public class LoginApi {

    @GetMapping
    public ResponseEntity<Void> obtenerLogin() {
        return ResponseEntity.ok().build();
    }
}
