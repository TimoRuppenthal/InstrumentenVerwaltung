package org.example;

import java.util.List;
public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        InstrumentenVerwaltung instrumentenVerwaltung = new InstrumentenVerwaltung();
        Instrument guitar =new Instrument("Gitarre",450,"Fender");
        Instrument klavier =new Instrument("Klavier",1000,"Yamaha");
        instrumentenVerwaltung.add(guitar);
        instrumentenVerwaltung.add(klavier);

        List<Instrument> alleInstrumente = instrumentenVerwaltung.get();
        alleInstrumente.forEach( element -> System.out.println(element.getInstrumentenArt()));
    }
}