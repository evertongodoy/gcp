package br.senac.sp.gcp.database;

import br.senac.sp.gcp.dtos.MensagemDTO;

public interface Mensagem {

    MensagemDTO salvarMensagem(MensagemDTO mensagemDTO);
}
