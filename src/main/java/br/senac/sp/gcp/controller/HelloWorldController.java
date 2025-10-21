package br.senac.sp.gcp.controller;

import br.senac.sp.gcp.controller.request.MensagemRequest;
import br.senac.sp.gcp.controller.response.HelloWorldResponse;
import br.senac.sp.gcp.controller.response.MensagemResponse;
import br.senac.sp.gcp.database.Mensagem;
import br.senac.sp.gcp.dtos.MensagemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("gcp")
@RequiredArgsConstructor
public class HelloWorldController {

    final Mensagem mensagem;

    @GetMapping("hello-world")
    public ResponseEntity<HelloWorldResponse> helloWorld() {
        return ResponseEntity.ok().body(
                new HelloWorldResponse("Hello, World, atualizado!!")
        );
    }

    @PostMapping("salvar-mensagem")
    public ResponseEntity<MensagemResponse> cadastrarMensagem(@RequestBody MensagemRequest request){
        var dto = mensagem.salvarMensagem(request.toDTO());
        return ResponseEntity.ok().body(
                dto.toResponse()
        );
    }

}