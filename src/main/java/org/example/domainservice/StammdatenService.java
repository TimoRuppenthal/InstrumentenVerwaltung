package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.*;

import java.util.List;

@DomainService
public class StammdatenService {

    private final InstrumentenRepository instrumentenRepository;

    public StammdatenService(InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }

    public void initStammdaten(){

            final Instrument gitarre = new Instrument(new InstrumentenDaten("Gitarre", 450, "Fender"),new EMailAdresse("ruppenthal.timo@gmail.com"));
            final Instrument klavier = new Instrument(new InstrumentenDaten("Klavier", 1000, "Yamaha"),new EMailAdresse("planta.jeremie@gmail.com"));

            List<Instrument> alleInstrumente = instrumentenRepository.getAll();
            if(!alleInstrumente.contains(gitarre)){
                instrumentenRepository.add(gitarre);
            }
            if(!alleInstrumente.contains(klavier)){
                instrumentenRepository.add(klavier);
            }
            instrumentenRepository
                    .getAll()
                    .forEach( element -> System.out.println(element.getInstrumentenArt()));
        }
    }


