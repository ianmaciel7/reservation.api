package br.com.ucsal.reservation.api.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import br.com.ucsal.reservation.api.data.entities.Laboratory;
import br.com.ucsal.reservation.api.models.MemoryList;

@Repository
public class LaboratoryRepositoryMemory implements LaboratoryRepository {

    private static MemoryList<Laboratory> context = new MemoryList<Laboratory>();

    static {
        context.add(new Laboratory(context.autoIncrement(), "Teste 1", 400, 'c'));
        context.add(new Laboratory(context.autoIncrement(), "Teste 2", 500, 'c'));
        context.add(new Laboratory(context.autoIncrement(), "Teste 3", 600, 'c'));
    }

    @Override
    public Laboratory add(Laboratory laboratory) {
        laboratory.setId(context.autoIncrement());
        context.add(laboratory);
        return context.stream()
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

        context.remove(laboratory);
    }

    @Override
    public Laboratory getById(int laboratoryId) {
        Laboratory lab = context.stream()
                .filter((l) -> l.getId() == laboratoryId)
                .findFirst()
                .orElse(null);

        return lab;
    }

    @Override
    public List<Laboratory> findAll(int pageNumber, int pageSize) {

        Stream<Laboratory> page = context.stream().skip(pageNumber).limit(pageSize);
        return page.toList();
    }
}
