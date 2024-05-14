package be.vdab.fietsen.docenten;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "docenten")

public class Docent {
    @Id
    private long id;
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;
}
