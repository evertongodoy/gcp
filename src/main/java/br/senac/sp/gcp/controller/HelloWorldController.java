package br.senac.sp.gcp.controller;

import br.senac.sp.gcp.controller.response.HelloWorldResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gcp")
public class HelloWorldController {

    @GetMapping("hello-world")
    public ResponseEntity<HelloWorldResponse> helloWorld() {
        return ResponseEntity.ok().body(
                new HelloWorldResponse("Hello, World, atualizado!!")
        );
    }

}