package be.vdab.fietsen.docenten;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("docenten")


class DocentController {
    private final DocentService docentService;

    public DocentController(DocentService docentService) {
        this.docentService = docentService;
    }
    @GetMapping("aantal")
    long findAantal() {
        return docentService.findAantal();
    }
    @GetMapping
    List<Docent> findAll() {
        return docentService.findAll();
    }
    @GetMapping("{id}")
    Docent findById(@PathVariable long id) {
        return docentService.findById(id)
                .orElseThrow(DocentNietGevondenException::new);
    }
    @GetMapping("{id}/bestaat")
    boolean bestaatById(@PathVariable long id) {
        return docentService.existsById(id);
    }
    @PostMapping
    long create(@RequestBody @Valid NieuweDocent nieuweDocent) {
        return docentService.create(nieuweDocent);
    }
    @DeleteMapping("{id}")
    void delete(@PathVariable long id) {
        try {
            docentService.delete(id);
        } catch (EmptyResultDataAccessException ignored) {
        }
    }
    @GetMapping(params = "wedde")
    List<Docent> findByWedde(BigDecimal wedde) {
        return docentService.findByWedde(wedde);
    }
    @GetMapping(params = "emailAdres")
    Docent findByEmailAdres(String emailAdres) {
        return docentService.findByEmailAdres(emailAdres)
                .orElseThrow(DocentNietGevondenException::new);
    }
    @GetMapping(value="aantal", params="wedde")
    int findAantalMetWedde(BigDecimal wedde) {
        return docentService.findAantalMetWedde(wedde);
    }
    @GetMapping("{emailAdres}/exist")
    boolean existsByEmailAdres(@PathVariable String emailAdres){
        return docentService.existsByEmailAdres(emailAdres);
    }
    @GetMapping(value = "existGreaterThan",params = "vanaf")
    boolean existByWeddeGreaterThan(BigDecimal vanaf){
        return docentService.existsByWeddeGreaterThan(vanaf);
    }
    @Transactional
    @DeleteMapping("eliminar/{emailAdres}")
    void deleteByEmailAdres( @PathVariable String emailAdres) {
        try {
            docentService.deleteByEmailAdres(emailAdres);
        } catch (EmptyResultDataAccessException ignored) {
        }
    }
    @Transactional
    @DeleteMapping(value = "eliminarByWeddeGreaterThan",params = "vanaf")
    void deleteByWeddeGreaterThan(BigDecimal vanaf){
        docentService.deleteByWeddeGreaterThan(vanaf);
    }
    @GetMapping("metGrootsteWedde")
    List<Docent> findMetGrootsteWedde() {
        return docentService.findMetGrootsteWedde();
    }
    @GetMapping("weddes/grootste")
    BigDecimal findGrootsteWedde() {
        return docentService.findGrootsteWedde();
    }
    @GetMapping("namen")
    List<EnkelNaam> findNamen() {
        return docentService.findNamen();
    }
    @GetMapping("aantalPerWedde")
    List<AantalDocentenPerWedde> findAantalDocentenPerWedde() {
        return docentService.findAantalDocentenPerWedde();
    }
    @PatchMapping("{id}/wedde")
    void wijzigWedde(@PathVariable long id,
                     @RequestBody @NotNull @Positive BigDecimal wedde){
        docentService.wijzigWedde(id, wedde);
    }


}
