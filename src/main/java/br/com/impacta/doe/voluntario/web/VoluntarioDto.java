package br.com.impacta.doe.voluntario.web;

import br.com.impacta.doe.voluntario.application.domain.Voluntario;
import lombok.Data;

@Data
public class VoluntarioDto {
    private Long id;
    private String campanhaId;
    private String usuarioid;
    private String statusVoluntario;

    public VoluntarioDto() {
    }

    public VoluntarioDto(Voluntario voluntario) {
        this.id = voluntario.getId();
        this.campanhaId = voluntario.getCampanhaId();
        this.usuarioid = voluntario.getUsuarioid();
        this.statusVoluntario = voluntario.getStatusVoluntario();
    }

    public Voluntario converte() {
        Voluntario voluntario = new Voluntario();
        voluntario.setCampanhaId(this.campanhaId);
        voluntario.setUsuarioid(this.usuarioid);
        return voluntario;
    }
}
