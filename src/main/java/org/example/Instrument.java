package org.example;

import java.util.Objects;

public class Instrument {
    private final String instrumentenArt;
    private final int preis;
    private final String marke;


    public Instrument(String instrumentenArt, int preis, String marke) {
        this.instrumentenArt = instrumentenArt;
        this.preis = preis;
        this.marke = marke;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instrument instrument = (Instrument) o;
        return Objects.equals(instrumentenArt, instrument.instrumentenArt) && Objects.equals(preis, instrument.preis) && Objects.equals(marke, instrument.marke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentenArt, preis,marke);
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
}

