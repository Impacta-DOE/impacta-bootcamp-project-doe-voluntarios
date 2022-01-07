package br.com.impacta.doe.voluntario.application.service;

import br.com.impacta.doe.voluntario.application.domain.Voluntario;
import br.com.impacta.doe.voluntario.infra.database.voluntario.VoluntarioRepository;
import br.com.impacta.doe.voluntario.web.VoluntarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {
    private VoluntarioRepository repository;

    @Autowired
    public VoluntarioServiceImpl(VoluntarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public VoluntarioDto salva(VoluntarioDto dto) {
        Voluntario voluntario = dto.converte();
        Voluntario voluntarioSalvo = repository.save(voluntario);
        return new VoluntarioDto(voluntarioSalvo);
    }

    @Transactional
    @Override
    public VoluntarioDto aceita(Long id) {
        Optional<Voluntario> optionalVoluntario = repository.findById(id);
        if (optionalVoluntario.isPresent()) {
            Voluntario voluntario = optionalVoluntario.get();
            voluntario.setId(id);
            voluntario.aceita();
            Voluntario voluntarioAceito = repository.save(voluntario);
            return new VoluntarioDto(voluntarioAceito);
        }
        throw new IllegalArgumentException("Voluntário não encontrado");
    }

    @Override
    public VoluntarioDto cancelaInscrição(Long id) {
        Optional<Voluntario> optionalVoluntario = repository.findById(id);
        if (optionalVoluntario.isPresent()) {
            Voluntario voluntario = optionalVoluntario.get();
            voluntario.setId(id);
            voluntario.cancelaInscricao();
            Voluntario voluntarioCancelado = repository.save(voluntario);
            return new VoluntarioDto(voluntarioCancelado);
        }
        throw new IllegalArgumentException("Voluntário não encontrado");
    }
}
