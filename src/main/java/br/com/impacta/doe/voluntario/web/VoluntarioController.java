package br.com.impacta.doe.voluntario.web;

import br.com.impacta.doe.voluntario.application.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping
    public VoluntarioDto salva(@RequestBody VoluntarioDto dto) {
        return voluntarioService.salva(dto);
    }

    @PostMapping("/aceita/{id}")
    public VoluntarioDto aceita(@RequestParam Long id) {
        return voluntarioService.aceita(id);
    }

    @PostMapping("/cancelaInscricao/{id}")
    public VoluntarioDto cancela(@RequestParam Long id) {
        return voluntarioService.aceita(id);
    }
}
