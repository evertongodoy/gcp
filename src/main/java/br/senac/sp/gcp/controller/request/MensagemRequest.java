package br.senac.sp.gcp.controller.request;

import br.senac.sp.gcp.dtos.MensagemDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MensagemRequest {

    private String mensagem;

    public MensagemDTO toDTO() {
        return MensagemDTO.builder()
                .mensagem(this.mensagem)
                .build();
    }

}