package br.senac.sp.gcp.controller;

import br.senac.sp.gcp.controller.response.HelloWorldResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("gcp")
@RequiredArgsConstructor
public class HelloWorldController {

    @GetMapping("hello-world")
    public ResponseEntity<HelloWorldResponse> helloWorld() {
        return ResponseEntity.ok().body(
                new HelloWorldResponse("Hello, World, atualizado!!")
        );
    }

}