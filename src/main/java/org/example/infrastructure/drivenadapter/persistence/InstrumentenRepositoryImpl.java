package org.example.infrastructure.drivenadapter.persistence;
import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;
import org.example.domain.SerienNummer;

import java.util.List;
import java.util.Properties;

@DrivenAdapter
public class InstrumentenRepositoryImpl implements InstrumentenRepository {
    private final IRepository<Instrument, SerienNummer> repository;

    public InstrumentenRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Instrument.class, Instrument::getSeriennummer, properties);
    }
    @Override
    public List<Instrument> getAll() {
        return repository.get();
    }

    @Override
    public void remove(SerienNummer serienNummer) {
        repository.remove(serienNummer);

    }

    @Override
    public void add(Instrument instrument) {
        repository.add(instrument);

    }
}
