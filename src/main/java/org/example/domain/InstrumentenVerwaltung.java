package org.example.domain;

import java.util.List;

public class InstrumentenVerwaltung {
    private final InstrumentenRepository instrumentenRepository;

    public void add(Instrument instrument){
        instrumentenRepository.add(instrument);
    }
    @SuppressWarnings("unused")
    public void delete(Instrument instrument){
        instrumentenRepository.remove(instrument);
    }

    public List<Instrument> get(){
        return instrumentenRepository.getAll();
    }
    public InstrumentenVerwaltung (InstrumentenRepository instrumentenRepository){
        this.instrumentenRepository = instrumentenRepository;
    }
}
