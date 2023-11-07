package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;
import java.util.List;

@ApplicationService
public class InstrumentenVerwaltung {
    private final InstrumentenRepository instrumentenRepository;

    public void add(EMailAdresse eMailAdresse, InstrumentenDaten instrumentenDaten){
        instrumentenRepository.add(new Instrument(instrumentenDaten, eMailAdresse));
    }
    @SuppressWarnings("unused")
    public void delete(EMailAdresse eMailAdresse){
        instrumentenRepository.remove(eMailAdresse);
    }

    public List<EMailAdresse> get(){
        return instrumentenRepository.getAll()
                .stream()
                .map(Instrument::getEMailAdresse)
                .toList();
    }

    public InstrumentenVerwaltung(InstrumentenRepository instrumentenRepository){this.instrumentenRepository = instrumentenRepository;}
    public void registriere(EMailAdresse eMailAdresse, InstrumentenDaten instrumentenDaten){
    }
    public void verifiziere(EMailAdresse eMailAdresse, VerifizierungsCode verifizierungsCode){
    }
}
