package rs.ac.singidunum.booking_api.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.booking_api.entity.RezervacijaTip;
import rs.ac.singidunum.booking_api.model.RezervazijaTipModel;
import rs.ac.singidunum.booking_api.repository.RezervacijaTipRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class RezervacijaTipService {
    private final RezervacijaTipRepository repository;

    public List<RezervacijaTip> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }
    public Optional<RezervacijaTip> getById(int id) {
        return repository.findByIdAndDeletedAtIsNull(id);
    }
    public RezervacijaTip saveRezervacijaTip(RezervazijaTipModel model) {
        RezervacijaTip rezervacijaTip = new RezervacijaTip();
        rezervacijaTip.setName(model.getName());
        rezervacijaTip.setCreatedAt(LocalDateTime.now());
        return repository.save(rezervacijaTip);
    }
    public RezervacijaTip updateRezervacijaTip(Integer id,RezervazijaTipModel model) {
        RezervacijaTip rezervacijaTip = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        rezervacijaTip.setName(model.getName());
        rezervacijaTip.setUpdatedAt(LocalDateTime.now());
        return repository.save(rezervacijaTip);
    }
    public void deleteRezervacijaTip(Integer id) {
        RezervacijaTip rezervacijaTip = repository.findByIdAndDeletedAtIsNull(id).orElseThrow();
        rezervacijaTip.setDeletedAt(LocalDateTime.now());
        repository.save(rezervacijaTip);
    }
}
