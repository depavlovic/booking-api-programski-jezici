package rs.ac.singidunum.booking_api.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class RezervacijaModel {
    private String name;
    private String surname;
    private String room;
    private Integer tipRezervacije;

}
