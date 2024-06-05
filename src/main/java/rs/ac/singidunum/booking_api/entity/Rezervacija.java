package rs.ac.singidunum.booking_api.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name="rezervacija")
@NoArgsConstructor
@Getter
@Setter
public class Rezervacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rezervacija_id")
    private Integer id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private Integer room;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rezervacija_tip_id",nullable = false)
    private RezervacijaTip rezervacijaTip;


    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;



}
