package br.com.ucsal.reservation.api.services;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ucsal.reservation.api.inputModels.LaboratoryPatchInputModel;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;

@Component
public interface LaboratoryService {
    public LaboratoryViewModel add(LaboratoryViewModel laboratoryViewModel) throws Exception;

    public LaboratoryViewModel patch(LaboratoryPatchInputModel newLaboratoryPatchInputModel) throws Exception;

    public void removeById(int laboratoryId) throws Exception;

    public LaboratoryViewModel findById(int laboratoryId) throws Exception;

    public List<LaboratoryViewModel> findAllByIdle(int pageNumber, int pageSize) throws Exception;

}