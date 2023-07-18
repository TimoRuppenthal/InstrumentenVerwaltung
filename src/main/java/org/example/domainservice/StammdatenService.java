package org.example.domainservice;

import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;

import java.util.List;

public class StammdatenService {
    private final InstrumentenRepository instrumentenRepository;

    public StammdatenService(InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }

    public void initStammdaten(){
        List<Instrument> alleInstrumente = instrumentenRepository.getAll();
        if(!alleInstrumente.contains(new Instrument("Gitarre", 450, "Fender"))){
            instrumentenRepository.add(new Instrument("Gitarre", 450, "Fender"));
        }
        if(!alleInstrumente.contains(new Instrument("Klavier", 1000, "Yamaha"))){
            instrumentenRepository.add(new Instrument("Klavier", 1000, "Yamaha"));
    }
        instrumentenRepository
                .getAll()
                .forEach( element -> System.out.println(element.getInstrumentenArt()));
    }
}


