package rs.ac.singidunum.booking_api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.booking_api.entity.RezervacijaTip;

import java.util.List;
import java.util.Optional;

@Repository
public interface RezervacijaTipRepository extends JpaRepository<RezervacijaTip,Integer> {

    List<RezervacijaTip> findAllByDeletedAtIsNull();

    Optional<RezervacijaTip> findByIdAndDeletedAtIsNull(Integer id);
}
