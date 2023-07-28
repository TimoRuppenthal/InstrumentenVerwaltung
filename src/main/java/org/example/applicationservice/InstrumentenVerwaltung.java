package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;
import org.example.domain.SerienNummer;
import org.example.domain.InstrumentenDaten;

import java.util.List;

@ApplicationService
public class InstrumentenVerwaltung {
    private final InstrumentenRepository instrumentenRepository;

    public void add(SerienNummer seriennummer, InstrumentenDaten instrumentenDaten){
        instrumentenRepository.add(new Instrument(instrumentenDaten, seriennummer));
    }
    @SuppressWarnings("unused")
    public void delete(SerienNummer serienNummer){
        instrumentenRepository.remove(serienNummer);
    }

    public List<SerienNummer> get(){
        return instrumentenRepository.getAll()
                .stream()
                .map(Instrument::getSeriennummer)
                .toList();
    }

    public InstrumentenVerwaltung (InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }
}
