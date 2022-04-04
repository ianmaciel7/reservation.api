package br.com.ucsal.reservation.api.services;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;

@Component
public interface LaboratoryService {
    public LaboratoryViewModel add(LaboratoryViewModel laboratoryViewModel) throws Exception;

    public LaboratoryViewModel update(LaboratoryViewModel newLaboratoryViewModel) throws Exception;

    public void removeById(int laboratoryId) throws Exception;

    public LaboratoryViewModel getById(int laboratoryId) throws Exception;

    public LaboratoryViewModel findAllByIdle(int pageNumber, int pageSize) throws Exception;
}