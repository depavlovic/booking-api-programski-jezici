package rs.ac.singidunum.booking_api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.booking_api.entity.RezervacijaTip;
import rs.ac.singidunum.booking_api.model.RezervazijaTipModel;
import rs.ac.singidunum.booking_api.service.RezervacijaTipService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path="/api/rezervacija_tip")
public class RezervacijaTipController {

    private final RezervacijaTipService service;

    @GetMapping
    public List<RezervacijaTip> getAll() {
        return service.getAll();
    }
    @GetMapping(path="/{id}")
    public ResponseEntity<RezervacijaTip> getById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public RezervacijaTip create(@RequestBody RezervazijaTipModel model) {
        return service.saveRezervacijaTip(model);
    }
    @PutMapping
    public RezervacijaTip update(@PathVariable Integer id,@RequestBody RezervazijaTipModel model) {
        return service.updateRezervacijaTip(id, model);
    }

    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        service.deleteRezervacijaTip(id);
    }

}
