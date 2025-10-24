package br.senac.sp.gcp.controller;

import br.senac.sp.gcp.controller.request.MensagemRequest;
import br.senac.sp.gcp.controller.response.HelloWorldResponse;
import br.senac.sp.gcp.controller.response.MensagemResponse;
import br.senac.sp.gcp.database.Mensagem;
import br.senac.sp.gcp.usecase.RecuperaInstituicao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("gcp")
@RequiredArgsConstructor
public class HelloWorldController {

    final Mensagem mensagem;
    final RecuperaInstituicao recuperaInstituicao;

    @GetMapping("hello-world")
    public ResponseEntity<HelloWorldResponse> helloWorld() {
        return ResponseEntity.ok().body(
                new HelloWorldResponse("Hello, World, atualizado!!")
        );
    }

    @PostMapping("salvar-mensagem")
    public ResponseEntity<MensagemResponse> cadastrarMensagem(@RequestBody MensagemRequest request){
        var dto = mensagem.salvarMensagem(request.toDTO());
        return ResponseEntity.ok().body(dto.toResponse());
    }

    @GetMapping("get-instituicao/project-id/{projectId}/secret-id/{secretId}")
    public ResponseEntity<String> getInstituicao(@PathVariable String projectId,
                                                 @PathVariable String secretId,
                                                 @RequestParam(required = false, defaultValue="latest") String version) {
        if(Objects.isNull(version)){
            var instituicao = recuperaInstituicao.recuperarInstituicao(projectId, secretId);
            return ResponseEntity.ok().body(instituicao);
        } else {
            var instituicao = recuperaInstituicao.recuperarInstituicao(projectId, secretId, version);
            return ResponseEntity.ok().body(instituicao);
        }
    }

}