package br.com.ucsal.reservation.api.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;

@Component
public interface LaboratoryRepository {
    public Laboratory add(Laboratory laboratory);

    public Laboratory update(Laboratory oldLaboratory, Laboratory newLaboratory);

    public void remove(Laboratory laboratory);

    public Laboratory getById(int laboratoryId);

    public List<Laboratory> findAll(int pageNumber, int pageSize);
}
