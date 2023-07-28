package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;

import java.util.List;

@Repository
public interface InstrumentenRepository {
    List<Instrument> getAll();

    void remove(SerienNummer serienNummer);

    void add(Instrument instrument);
}
