package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;
@Aggregate
public class Instrument {
    private InstrumentenDaten instrumentenDaten;
    private final VerifizierungsCode seriennummer;


    public Instrument(InstrumentenDaten instrumentenDaten, VerifizierungsCode seriennummer) {
        this.instrumentenDaten = instrumentenDaten;
        this.seriennummer = seriennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return Objects.equals(getSeriennummer(), instrument.getSeriennummer());
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
    public VerifizierungsCode getSeriennummer(){return seriennummer; }
    public void setInstrumentenDaten(InstrumentenDaten instrumentenDaten){
        this.instrumentenDaten = instrumentenDaten;
    }
}

