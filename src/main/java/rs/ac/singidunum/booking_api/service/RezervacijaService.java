package rs.ac.singidunum.booking_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.booking_api.entity.Rezervacija;
import rs.ac.singidunum.booking_api.entity.RezervacijaTip;
import rs.ac.singidunum.booking_api.model.RezervacijaModel;
import rs.ac.singidunum.booking_api.repository.RezervacijaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RezervacijaService {


    private final RezervacijaRepository rezervacijaRepository;
    private final RezervacijaTipService rezervacijaTipService;

    public List<Rezervacija> getAll() {
     return  rezervacijaRepository.findAllByDeletedAtIsNull();
    }
    public Optional<Rezervacija> getById(int id) {
        return rezervacijaRepository.findByIdAndDeletedAtIsNull(id);
    }

    public Rezervacija createRezervacija(RezervacijaModel model) {
        RezervacijaTip rezervacijaTip = rezervacijaTipService.getById(model.getTipRezervacije()).orElseThrow();
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setName(model.getName());
        rezervacija.setSurname(model.getSurname());
        rezervacija.setRoom(rezervacija.getRoom());
        rezervacija.setRezervacijaTip(rezervacijaTip);
        rezervacija.setCreatedAt(LocalDateTime.now());
        return rezervacijaRepository.save(rezervacija);
    }
    public Rezervacija updateRezervacija(Integer id,RezervacijaModel model) {
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        RezervacijaTip rezervacijaTip = rezervacijaTipService.getById(model.getTipRezervacije()).orElseThrow();
        rezervacija.setName(model.getName());
        rezervacija.setSurname(model.getSurname());
        rezervacija.setRoom(rezervacija.getRoom());
        rezervacija.setRezervacijaTip(rezervacijaTip);
        rezervacija.setUpdatedAt(LocalDateTime.now());
        return rezervacijaRepository.save(rezervacija);
    }
    public void deleteRezervacija(Integer id) {
        Rezervacija rezervacija = rezervacijaRepository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        rezervacija.setDeletedAt(LocalDateTime.now());
        rezervacijaRepository.save(rezervacija);
    }
}
