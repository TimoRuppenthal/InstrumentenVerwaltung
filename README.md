# InstrumentenVerwaltung
Dieses Projekt dient dem Training der Grundlagen in der Software-Entwicklung.
Dieses Projekt soll folgende Features anbieten: 
* Hinzufügen eines Instrumentes in die InstrumentenVerwaltung
* Löschen eines Instrumentes aus der InstrumentenVerwaltung
* Anzeigen der aktuell verfügbaren Instrumente in der InstrumentenVerwaltung

[User-Story]Als Manager der InstrumentenVerwaltung möchte ich, dass neue Instrumente beim Hinzufügen in die InstrumentenVerwaltung registriert werden müssen, damit diese automatisiert verifiziert werden können. 
* Bei der Registrierung muss eine gültige E-Mail-Adresse und die InstrumentenDaten angegeben werden
* Es wird ein 6-stelliger Verifizierungscode an die angegebene E-Mail-Adresse verschickt
* Damit ein Instrument in die InstrumentenVerwaltung aufgenommen werden kann, müssen E-Mail-Adresse und Verifizierungscode übergeben werden
* Der Verifizierungscode verliert nach 24 Stunden seine Gültigkeit


Abbildung auf DDD Mustersprache und Klassen

Applicationservice: InstrumentenVerwaltung
    Neue Methoden: registriere und verifiziere
ValueObject: E-Mail-Adresse, InstrumentenDaten, VerifizierungsCode
Aggregate: RegistrierungsDaten
Repository: RegistrierungsDatenRepository
DomainEvent: VerifizierungsCodeVerschickt