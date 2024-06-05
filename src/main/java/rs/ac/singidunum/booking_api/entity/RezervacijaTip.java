package rs.ac.singidunum.booking_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name="rezervacija_tip")
public class RezervacijaTip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rezervacija_tip_id")
    private Integer id;
    @Column(unique = true,nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @JsonIgnore
    private LocalDateTime deletedAt;
}
