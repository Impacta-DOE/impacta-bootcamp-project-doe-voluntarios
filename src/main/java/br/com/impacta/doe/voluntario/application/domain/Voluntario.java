package br.com.impacta.doe.voluntario.application.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Voluntario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String campanhaId;
    private String usuarioid;
    private String statusVoluntario;

    public Voluntario() {
        this.statusVoluntario = "PENDENTE";
    }

    public void aceita() {
        this.statusVoluntario = "ATIVO";
    }

    public void cancelaInscricao() {
        this.statusVoluntario = "INATIVO";
    }
}
