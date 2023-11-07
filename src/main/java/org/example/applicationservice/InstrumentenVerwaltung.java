package org.example.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import org.example.domain.*;
import org.example.domainservice.VerifizierungsCodeSender;
import java.util.List;

@ApplicationService
public class InstrumentenVerwaltung {
    private final InstrumentenRepository instrumentenRepository;
    private final RegistrierungsDatenRepository registrierungsDatenRepository;

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

    public InstrumentenVerwaltung(InstrumentenRepository instrumentenRepository, RegistrierungsDatenRepository registrierungsDatenRepository){this.instrumentenRepository = instrumentenRepository; this.registrierungsDatenRepository = registrierungsDatenRepository;}
    public void registriere(EMailAdresse eMailAdresse, InstrumentenDaten instrumentenDaten){registrierungsDatenRepository.add(new RegistrierungsDaten(eMailAdresse, instrumentenDaten));
    }
    public void verifiziere(EMailAdresse eMailAdresse, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(eMailAdresse).orElseThrow();
        registrierungsDaten.verifiziere(verifizierungsCode);
        add(eMailAdresse,registrierungsDaten.getInstrumentenDaten());
        registrierungsDatenRepository.remove(eMailAdresse);
    }
}
