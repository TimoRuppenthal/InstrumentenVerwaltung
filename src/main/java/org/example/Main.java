package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;

import java.util.List;

public class Main {
    @SuppressWarnings("java:S106")
    public static void main(String[] args) {
        InstrumentenVerwaltung instrumentenVerwaltung = new InstrumentenVerwaltung();
        Instrument guitar =new Instrument("Gitarre",450,"Fender");
        Instrument klavier =new Instrument("Klavier",1000,"Yamaha");
        instrumentenVerwaltung.add(guitar);
        instrumentenVerwaltung.add(klavier);
        instrumentenVerwaltung.delete(klavier);

        List<Instrument> alleInstrumente = instrumentenVerwaltung.get();
        alleInstrumente.forEach(element -> System.out.println(element.getInstrumentenArt()));
        alleInstrumente.forEach( element -> System.out.println(element.getPreis()));
        alleInstrumente.forEach( element -> System.out.println(element.getMarke()));
        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(instrumentenVerwaltung)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}