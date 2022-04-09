package br.com.ucsal.reservation.api.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;

@Component
public interface LaboratoryRepository {
    public Laboratory add(Laboratory laboratory);

    public Laboratory update(Laboratory oldLaboratory, Laboratory newLaboratory);

    public void remove(Laboratory laboratory) throws Exception;

    public Laboratory findById(int laboratoryId);

    public List<Laboratory> findAllByIdle(int pageNumber, int pageSize);

    public Laboratory patch(Laboratory oldLaboratory, Laboratory newLaboratory);

}
