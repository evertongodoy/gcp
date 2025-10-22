package br.senac.sp.gcp.database.impl;

import br.senac.sp.gcp.database.Mensagem;
import br.senac.sp.gcp.database.entities.MensagemEntity;
import br.senac.sp.gcp.database.repository.MensagemRepository;
import br.senac.sp.gcp.dtos.MensagemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MensagemImpl implements Mensagem {

    private final MensagemRepository repository;

    @Override
    public MensagemDTO salvarMensagem(MensagemDTO mensagemDTO) {
        var entity = MensagemEntity.builder()
                .mensagem(mensagemDTO.getMensagem())
                .build();
        var savedEntity = repository.save(entity);
        return savedEntity.toDTO();
    }

}