package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RegistrierungsDatenTest {
    @Test
    void testErstelleVerifizierungsCode(){
        //Arrange
        var emailAdresse = new EMailAdresse("rpthl@gmail.com");
        var instrumentenDaten = new InstrumentenDaten("Gitarre", 3199, "Paul Reed Smith");
        var objectUnderTest = new RegistrierungsDaten(emailAdresse, instrumentenDaten);
        var receivedDomainEvents = new ArrayList<VerifizierungsCodeVerschickt>();

        DomainEventPublisher.subscribe(VerifizierungsCodeVerschickt.class, receivedDomainEvents::add);

        //Act
        objectUnderTest.sendVerifizierungsCode();

        //Assert
        assertEquals(1, receivedDomainEvents.size());

        assertEquals(36, receivedDomainEvents.get(0).verifizierungsCode().verifizierungsCode().length());
    }
}
