package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;

import java.util.List;

@DomainService
public class StammdatenService {

    private static final Instrument Gitarre = new Instrument("Gitarre", 450, "Fender", 123);
    private static final Instrument Klavier = new Instrument("Klavier", 1000, "Yamaha", 234);

    private final InstrumentenRepository instrumentenRepository;

    public StammdatenService(InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }

    public void initStammdaten(){

            List<Instrument> alleInstrumente = instrumentenRepository.getAll();
            if(!alleInstrumente.contains(Gitarre)){
                instrumentenRepository.add(Gitarre);
            }
            if(!alleInstrumente.contains(Klavier)){
                instrumentenRepository.add(Klavier);
            }
            instrumentenRepository
                    .getAll()
                    .forEach( element -> System.out.println(element.getInstrumentenArt()));
        }
    }


