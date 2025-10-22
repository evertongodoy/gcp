package br.senac.sp.gcp.database.repository;

import br.senac.sp.gcp.database.entities.MensagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<MensagemEntity, Long> {
}
