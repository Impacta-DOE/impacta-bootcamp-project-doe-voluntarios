package br.com.impacta.doe.voluntario.web;

import br.com.impacta.doe.voluntario.application.service.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/voluntario")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @PostMapping
    public VoluntarioDto salva(@RequestBody VoluntarioDto dto) {
        return voluntarioService.salva(dto);
    }

    @PutMapping("/aceita/{id}")
    public VoluntarioDto aceita(@PathVariable Long id) {
        return voluntarioService.aceita(id);
    }

    @PutMapping("/cancelaInscricao/{id}")
    public VoluntarioDto cancela(@PathVariable Long id) {
        return voluntarioService.cancelaInscrição(id);
    }
}
