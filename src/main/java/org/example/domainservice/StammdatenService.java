package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.Instrument;
import org.example.domain.InstrumentenDaten;
import org.example.domain.InstrumentenRepository;
import org.example.domain.SerienNummer;

import java.util.List;

@DomainService
public class StammdatenService {

    private final InstrumentenRepository instrumentenRepository;

    public StammdatenService(InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }

    public void initStammdaten(){

            final Instrument Gitarre = new Instrument(new InstrumentenDaten("Gitarre", 450, "Fender"),new SerienNummer(123));
            final Instrument Klavier = new Instrument(new InstrumentenDaten("Klavier", 1000, "Yamaha"),new SerienNummer(234));

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


