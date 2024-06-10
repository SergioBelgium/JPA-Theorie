package be.vdab.fietsen.docenten;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "docenten")//esto puedes no ponerlo si el nombre de la clase ya coincide con el de la tabla!

public class Docent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;
    private String familienaam;
    private BigDecimal wedde;
    private String emailAdres;
    @Enumerated(EnumType.STRING)
    private Geslacht geslacht;
    @Version
    private long versie;



    public Docent(String voornaam, String familienaam, BigDecimal wedde, String emailAdres, Geslacht geslacht) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        this.wedde = wedde;
        this.emailAdres = emailAdres;
        this.geslacht = geslacht;
    }
    protected Docent(){}//esto es solo para el funcionamiento interno de JPA!

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public String getEmailAdres() {
        return emailAdres;
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public BigDecimal getWedde() {
        return wedde;
    }
    void setWedde(BigDecimal wedde) {
        this.wedde = wedde;
    }
}
