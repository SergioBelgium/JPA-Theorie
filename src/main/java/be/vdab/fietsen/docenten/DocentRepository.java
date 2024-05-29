package be.vdab.fietsen.docenten;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
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
    List<Docent> findMetGrootsteWedde();//ejemplo d DTO con "agregate resultaat" !!
    @Query("""
 select max(d.wedde) 
 from Docent d
 """)
    BigDecimal findGrootsteWedde();
                                        //ejemplo d DTO "slechts enkele kolommen lezen, y se crea interfaz "enkelnaam"
    @Query("""                      
 select d.voornaam as voornaam, d.familienaam as familienaam 
 from Docent d
 order by d.voornaam, d.familienaam
 """)
    List<EnkelNaam> findNamen();

    @Query("""
 select d.wedde as wedde, count(d) as aantal 
 from Docent d 
 group by d.wedde
 """)
    List<AantalDocentenPerWedde> findAantalDocentenPerWedde();
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select d from Docent d where d.id = :id")
    Optional<Docent> findAndLockById(long id);

}
