package com.inHealth.server.controller;

import com.inHealth.server.service.BiometricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class BiometricController {

    @Autowired
    private BiometricService biometricService;

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        try {
            String content = new String(file.getBytes());
            System.out.println(content);
            biometricService.uploadToHdfs(content, file.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Web Server InHealth", HttpStatus.OK);
    }
}
