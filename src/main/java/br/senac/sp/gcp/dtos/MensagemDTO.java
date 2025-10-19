package br.senac.sp.gcp.dtos;

import br.senac.sp.gcp.controller.response.MensagemResponse;
import br.senac.sp.gcp.database.entities.MensagemEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class MensagemDTO {

    private Long id;
    private String mensagem;
    private LocalDate dataCadastro;


    public MensagemResponse toResponse() {
        return MensagemResponse.builder()
                .id(this.id)
                .mensagem(this.mensagem)
                .dataCadastro(this.dataCadastro != null ? this.dataCadastro.toString() : null)
                .build();
    }


}
