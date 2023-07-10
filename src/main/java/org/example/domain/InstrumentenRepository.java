package org.example.domain;

import java.util.List;

public interface InstrumentenRepository {
    List<Instrument> getAll();

    void remove(Instrument instrument);

    void add(Instrument instrument);
}
