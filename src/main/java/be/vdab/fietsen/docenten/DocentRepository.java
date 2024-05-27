package be.vdab.fietsen.docenten;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface DocentRepository extends JpaRepository<Docent,Long> {
    List<Docent> findByWeddeOrderByFamilienaam(BigDecimal wedde);
    Optional<Docent> findByEmailAdres(String emailAdres);
    int countByWedde(BigDecimal wedde);
    boolean existsByEmailAdres(String emailAdres);
    boolean existsByWeddeGreaterThan(BigDecimal vanaf);
    void deleteByEmailAdres(String emailAdres);
    void deleteByWeddeGreaterThan(BigDecimal vanaf);
    @Query("""
 select d
 from Docent d
 where d.wedde = (select max(dd.wedde) from Docent dd)
 """)
    List<Docent> findMetGrootsteWedde();

}
