package rs.ac.singidunum.booking_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.booking_api.entity.Rezervacija;

import java.util.List;
import java.util.Optional;


@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Integer> {

    List<Rezervacija> findAllByDeletedAtIsNull();

    Optional<Rezervacija> findByIdAndDeletedAtIsNull(Integer id);


}
