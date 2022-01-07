package br.com.impacta.doe.voluntario.infra.database.voluntario;

import br.com.impacta.doe.voluntario.application.domain.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {
}
