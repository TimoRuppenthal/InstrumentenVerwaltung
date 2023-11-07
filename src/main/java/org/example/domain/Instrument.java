package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;
@Aggregate
public class Instrument {
    private InstrumentenDaten instrumentenDaten;
    private final EMailAdresse emailadresse;


    public Instrument(InstrumentenDaten instrumentenDaten, EMailAdresse emailadresse) {
        this.instrumentenDaten = instrumentenDaten;
        this.emailadresse = emailadresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return Objects.equals(getEMailAdresse(), instrument.getEMailAdresse());
    }

@SuppressWarnings("java:S106")
    public String getInstrumentenArt() {
        return instrumentenDaten.instrumentenart();
    }
@SuppressWarnings("unused")
    public int getPreis() {
        return instrumentenDaten.preis();
    }
@SuppressWarnings("unused")
    public String getMarke() {
        return instrumentenDaten.marke();
    }
@AggregateID
    public EMailAdresse getEMailAdresse(){return emailadresse; }
    public void setInstrumentenDaten(InstrumentenDaten instrumentenDaten){
        this.instrumentenDaten = instrumentenDaten;
    }
}

