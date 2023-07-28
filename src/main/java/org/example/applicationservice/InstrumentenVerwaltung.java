package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;
import org.example.domain.SerienNummer;

import java.util.List;

@ApplicationService
public class InstrumentenVerwaltung {
    private final InstrumentenRepository instrumentenRepository;

    public void add(Instrument instrument){
        instrumentenRepository.add(instrument);
    }
    @SuppressWarnings("unused")
    public void delete(Instrument instrument){
        instrumentenRepository.remove(instrument);
    }

    public List<SerienNummer> get(){
        return instrumentenRepository.getAll().stream().map(Instrument::getSeriennummer).toList();
    }

    public InstrumentenVerwaltung (InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }
}
