package br.com.ucsal.reservation.api.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import br.com.ucsal.reservation.api.models.MemoryDbContext;
import br.com.ucsal.reservation.api.models.MemoryList;
import br.com.ucsal.reservation.api.models.persistence.Laboratory;

@Repository
public class LaboratoryRepositoryMemory extends BaseRepository implements LaboratoryRepository {

    private MemoryDbContext context = new MemoryDbContext();

    public LaboratoryRepositoryMemory() {
        context.laboratories.add(new Laboratory(context.laboratories.autoIncrement(), "Teste 1", 400, 'c'));
        context.laboratories.add(new Laboratory(context.laboratories.autoIncrement(), "Teste 2", 500, 'c'));
        context.laboratories.add(new Laboratory(context.laboratories.autoIncrement(), "Teste 3", 600, 'c'));
    }

    @Override
    public Laboratory add(Laboratory laboratory) {
        laboratory.setId(context.laboratories.autoIncrement());
        context.laboratories.add(laboratory);
        return context.laboratories.stream()
                .filter((l) -> l.equals(laboratory))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Laboratory update(Laboratory oldLaboratory, Laboratory newLaboratory) {

        oldLaboratory.setName(newLaboratory.getName());
        oldLaboratory.setNumber(newLaboratory.getNumber());
        oldLaboratory.setSector(newLaboratory.getSector());

        return oldLaboratory;
    }

    @Override
    public void remove(Laboratory laboratory) {

        context.laboratories.remove(laboratory);
    }

    @Override
    public Laboratory getById(int laboratoryId) {
        Laboratory lab = context.laboratories.stream()
                .filter((l) -> l.getId() == laboratoryId)
                .findFirst()
                .orElse(null);

        return lab;
    }

    @Override
    public List<Laboratory> findAll(int pageNumber, int pageSize) {

        Stream<Laboratory> page = context.laboratories.stream().skip(pageNumber).limit(pageSize);
        return page.toList();
    }
}
