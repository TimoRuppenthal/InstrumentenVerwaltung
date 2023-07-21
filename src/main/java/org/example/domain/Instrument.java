package org.example.domain;

import java.util.Objects;

public class Instrument {
    private final String instrumentenArt;
    private final int preis;
    private final String marke;

    private final int seriennummer;


    public Instrument(String instrumentenArt, int preis, String marke, int seriennummer) {
        this.instrumentenArt = instrumentenArt;
        this.preis = preis;
        this.marke = marke;
        this.seriennummer = seriennummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return Objects.equals(instrumentenArt, instrument.instrumentenArt) && Objects.equals(preis, instrument.preis) && Objects.equals(marke, instrument.marke)&& Objects.equals(seriennummer, instrument.seriennummer);
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

    public int getSeriennummer(){return seriennummer; }
}

