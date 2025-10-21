package br.senac.sp.gcp.database.impl;

import br.senac.sp.gcp.database.Mensagem;
import br.senac.sp.gcp.database.entities.MensagemEntity;
import br.senac.sp.gcp.dtos.MensagemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MensagemImpl implements Mensagem {

    private Random random = new Random();

    @Override
    public MensagemDTO salvarMensagem(MensagemDTO mensagemDTO) {
        long rValue = this.random.nextLong();
        var entity = MensagemEntity.builder()
                .id(rValue)
                .mensagem(mensagemDTO.getMensagem())
                .dataCadastro(LocalDate.now())
                .build();
        return entity.toDTO();
    }

}