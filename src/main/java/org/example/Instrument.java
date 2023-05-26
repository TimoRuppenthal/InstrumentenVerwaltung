package org.example;

public class Instrument {
    private final String instrumentenArt;
    private final int preis;
    private final String marke;


    public Instrument(String instrumentenArt, int preis, String marke) {
        this.instrumentenArt = instrumentenArt;
        this.preis = preis;
        this.marke = marke;
    }
@SuppressWarnings("java:S106")
    public String getInstrumentenArt() {
        return instrumentenArt;
    }

    public int getPreis() {
        return preis;
    }

    public String getMarke() {
        return marke;
    }
}

