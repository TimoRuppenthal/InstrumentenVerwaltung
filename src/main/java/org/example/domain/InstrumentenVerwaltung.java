package org.example.domain;

import org.example.domain.Instrument;

import java.util.ArrayList;
import java.util.List;

public class InstrumentenVerwaltung {
    private final List<Instrument> instrumenteList  = new ArrayList<>();

    public void add(Instrument instrumente){
        instrumenteList.add(instrumente);
    }
    @SuppressWarnings("unused")
    public void delete(Instrument instrumente){
        instrumenteList.remove(instrumente);
    }
    public List<Instrument> get() {
        return instrumenteList;
    }
}
