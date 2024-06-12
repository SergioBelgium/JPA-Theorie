package be.vdab.fietsen.cursussen;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//con esto indicas el caso de la tabla por: clase herencia,sublcase, o clase concreta
@Table(name = "cursussen")
//@DiscriminatorColumn(name = "soort")//recuerda que el discriminador no pertenece a la entidad sino que lo utiliza internamente JPA!

abstract class Cursus {
    @Id
    private UUID id;
   // private long id;
    private String naam;

    public Cursus(UUID id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    protected Cursus() {
    }

    public UUID getId() {
        return id;
    }
}
