package rs.ac.singidunum.booking_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.booking_api.entity.Rezervacija;
import rs.ac.singidunum.booking_api.model.RezervacijaModel;
import rs.ac.singidunum.booking_api.service.RezervacijaService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/rezervacija")
@RequiredArgsConstructor
@CrossOrigin
public class RezervacijaController {

    private final RezervacijaService service;
    @GetMapping
    public List<Rezervacija> getRezervacija() {
        return service.getAll();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Rezervacija> getRezervacijaById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }
    @PostMapping
    public Rezervacija createRezervacija(@RequestBody RezervacijaModel rez) {
        return service.createRezervacija(rez);
    }
    @PutMapping(path="/{id}")
    public Rezervacija updateRezervacija(@PathVariable Integer id,@RequestBody RezervacijaModel rez) {
        return service.updateRezervacija(id, rez);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteRezervacija(@PathVariable Integer id) {
        service.deleteRezervacija(id);
    }

}
