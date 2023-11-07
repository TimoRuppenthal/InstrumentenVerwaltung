package org.example.infrastructure.drivenadapter.persistence;
import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.EMailAdresse;
import org.example.domain.Instrument;
import org.example.domain.InstrumentenRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@DrivenAdapter
public class InstrumentenRepositoryImpl implements InstrumentenRepository {
    private final IRepository<Instrument, EMailAdresse> repository;

    public InstrumentenRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Instrument.class, Instrument::getEMailAdresse, properties);
    }
    @Override
    public List<Instrument> getAll() {
        return repository.get();
    }

    @Override
    public void remove(EMailAdresse eMailAdresse) {
        repository.remove(eMailAdresse);

    }

    @Override
    public void add(Instrument instrument) {
        repository.add(instrument);

    }
    @Override
    public Optional<Instrument> get(EMailAdresse emailAdresse) {
        return repository.get(emailAdresse);
    }

    @Override
    public void update(Instrument instrument) {
        repository.update(instrument);
    }
}
