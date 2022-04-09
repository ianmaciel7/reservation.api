package br.com.ucsal.reservation.api.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.MemoryDbContext;
import br.com.ucsal.reservation.api.models.persistence.MemoryList;

@Repository
public class LaboratoryRepositoryMemory extends BaseRepository implements LaboratoryRepository {

    private MemoryDbContext context = new MemoryDbContext();

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
        oldLaboratory.setReservations(newLaboratory.getReservations());

        return oldLaboratory;
    }

    @Override
    public Laboratory patch(Laboratory oldLaboratory, Laboratory newLaboratory) {
        oldLaboratory.setName(newLaboratory.getName());
        oldLaboratory.setNumber(newLaboratory.getNumber());
        oldLaboratory.setSector(newLaboratory.getSector());

        return oldLaboratory;
    }

    @Override
    public void remove(Laboratory laboratory) throws Exception {
        if (laboratory.isIdle() == false)
            throw new Exception(
                    "Ainda existem reservas, para remover o Laboratório é necessario que não tenha reservas");
        context.laboratories.remove(laboratory);
    }

    @Override
    public Laboratory findById(int laboratoryId) {
        Laboratory lab = context.laboratories.stream()
                .filter((l) -> l.getId() == laboratoryId)
                .findFirst()
                .orElse(null);

        return lab;
    }

    @Override
    public List<Laboratory> findAllByIdle(int pageNumber, int pageSize) {
        List<Laboratory> page = context.laboratories.stream()
                .filter((l) -> l.isIdle() == true)
                .skip(pageNumber).limit(pageSize)
                .toList();
        return page;
    }

}
