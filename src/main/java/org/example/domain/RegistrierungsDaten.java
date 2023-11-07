package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

import static org.example.domain.DomainEventPublisher.publish;

@Aggregate
public class RegistrierungsDaten {
    private final InstrumentenDaten instrumentenDaten;
    private final EMailAdresse emailAdresse;
    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(EMailAdresse emailAdresse, InstrumentenDaten instrumentenDaten) {
        this.emailAdresse = emailAdresse;
        this.instrumentenDaten = instrumentenDaten;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
        sendVerifizierungsCode();
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }

    public InstrumentenDaten getInstrumentenDaten() {
        return instrumentenDaten;
    }
    public void verifiziere(VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        if (this.verifizierungsCode != verifizierungsCode) {
            throw new UngueltigerVerifizierungsCode();
        }
    }

    public void sendVerifizierungsCode(){
        publish(new VerifizierungsCodeVerschickt(emailAdresse, verifizierungsCode));
    }
    @AggregateID
    public EMailAdresse getEmailAdresse() {
        return emailAdresse;
    }
}
