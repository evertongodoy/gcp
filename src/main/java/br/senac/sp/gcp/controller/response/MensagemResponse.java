package br.senac.sp.gcp.controller.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemResponse {

    private Long id;
    private String mensagem;
    private String dataCadastro;

}