package br.com.impacta.doe.voluntario.application.service;

import br.com.impacta.doe.voluntario.web.VoluntarioDto;

public interface VoluntarioService {
    VoluntarioDto salva(VoluntarioDto dto);

    VoluntarioDto aceita(Long id);

    VoluntarioDto cancelaInscrição(Long id);
}
