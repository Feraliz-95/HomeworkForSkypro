package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/port")
    public int getPort() {
        return port;
    }

    @GetMapping("/sum-fast")
    public ResponseEntity<Long> getSumFast() {
        long n = 1_000_000L;
        long sum = n * (n + 1L) / 2L;
        return ResponseEntity.ok(sum);
    }



}
