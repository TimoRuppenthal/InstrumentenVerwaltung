package org.example.infrastructure.drivenadapter.persistence;

import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;

import java.util.ArrayList;
import java.util.List;

public class InstrumentenRepositoryImpl implements InstrumentenRepository {
    private final List<Instrument> instrumentenList = new ArrayList<>();
    @Override
    public List<Instrument> getAll() {
        return instrumentenList;
    }

    @Override
    public void remove(Instrument instrument) {
        instrumentenList.remove(instrument);

    }

    @Override
    public void add(Instrument instrument) {
        instrumentenList.add(instrument);

    }
}
