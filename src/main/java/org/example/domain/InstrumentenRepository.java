package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentenRepository {
    List<Instrument> getAll();

    void remove(EMailAdresse serienNummer);

    void add(Instrument instrument);
    Optional<Instrument> get(EMailAdresse emailAdresse);

    void update(Instrument instrument);
}
