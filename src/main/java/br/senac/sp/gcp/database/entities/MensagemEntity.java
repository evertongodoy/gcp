package br.senac.sp.gcp.database.entities;

import br.senac.sp.gcp.dtos.MensagemDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "mensagem")
@Data
@Builder
public class MensagemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// AUTO_INCREMENT no MySQL

    @Column(name = "mensagem", nullable = false, length = 500)
    private String mensagem;

    // Preenchido automaticamente na inserção
    @CreationTimestamp
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    // Opcional: garantir valor caso não use @CreationTimestamp
    @PrePersist
    public void prePersist() {
        if (this.dataCadastro == null) {
            this.dataCadastro = LocalDate.now();
        }
    }

    public MensagemDTO toDTO() {
        return MensagemDTO.builder()
                .id(this.id)
                .mensagem(this.mensagem)
                .dataCadastro(this.dataCadastro)
                .build();
    }

    public MensagemEntity toEntity(MensagemDTO dto) {
        return MensagemEntity.builder()
                .id(dto.getId())
                .mensagem(dto.getMensagem())
                .dataCadastro(dto.getDataCadastro())
                .build();
    }

}
