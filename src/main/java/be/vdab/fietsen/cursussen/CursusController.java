package be.vdab.fietsen.cursussen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cursussen")

public class CursusController {
    private final CursusService cursusService;

    public CursusController(CursusService cursusService) {
        this.cursusService = cursusService;
    }

    @GetMapping
    List<Cursus> findAll() {
        return cursusService.findAll();

    }
    //Als je een query nodig hebt waarin je enkel cursussen van een bepaald type
    //(bijvoorbeeld enkel groepscursussen) wil lezen, moet je die query maken met JPQL.
    @GetMapping("groep")
    List<GroepsCursus> findGroepsCursussen() {
        return cursusService.findGroepsCursussen();
    }
    @GetMapping("individueel")
    List<IndividueleCursus> findIndividueleCursussen() {
        return cursusService.findIndividueleCursussen();
    }


}
