package be.vdab.fietsen.cursussen;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@DiscriminatorValue("I")
@Table(name = "individuelecursussen")

public class IndividueleCursus extends Cursus{
    private int duurtijd;

    public int getDuurtijd() {
        return duurtijd;
    }
}
