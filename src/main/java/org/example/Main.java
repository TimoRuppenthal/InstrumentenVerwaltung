package org.example;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import org.example.domain.InstrumentenRepository;
import org.example.domain.InstrumentenVerwaltung;
import org.example.domainservice.StammdatenService;
import java.util.Properties;
import org.example.infrastructure.drivenadapter.persistence.InstrumentenRepositoryImpl;

public class Main {

    @SuppressWarnings("java:S106") //Okey da Demoprojekt
    public static void main(String[] args) {
        InstrumentenRepository instrumentenRepository = new InstrumentenRepositoryImpl(new Properties());

        InstrumentenVerwaltung instrumentenVerwaltung = new InstrumentenVerwaltung(instrumentenRepository);

        StammdatenService stammdatenService = new StammdatenService(instrumentenRepository);
        stammdatenService.initStammdaten();

        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(instrumentenVerwaltung)
                .bind(RESTfulRPCAdapter.class).to(Main.class)  // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}