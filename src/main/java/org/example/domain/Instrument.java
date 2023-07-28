package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;
@Aggregate
public class Instrument {
    private final String instrumentenArt;
    private final int preis;
    private final String marke;
    private final SerienNummer seriennummer;


    public Instrument(String instrumentenArt, int preis, String marke, int seriennummer) {
        this.instrumentenArt = instrumentenArt;
        this.preis = preis;
        this.marke = marke;
        this.seriennummer = new SerienNummer(seriennummer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return Objects.equals(getSeriennummer(), instrument.getSeriennummer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentenArt, preis, marke, seriennummer);
    }

@SuppressWarnings("java:S106")
    public String getInstrumentenArt() {
        return instrumentenArt;
    }
@SuppressWarnings("unused")
    public int getPreis() {
        return preis;
    }
@SuppressWarnings("unused")
    public String getMarke() {
        return marke;
    }
@AggregateID
    public SerienNummer getSeriennummer(){return seriennummer; }
}

