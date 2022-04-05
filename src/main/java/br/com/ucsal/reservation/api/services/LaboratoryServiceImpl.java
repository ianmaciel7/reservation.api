package br.com.ucsal.reservation.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.repositories.LaboratoryRepository;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;

@Service
public class LaboratoryServiceImpl extends BaseService implements LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Override
    public LaboratoryViewModel add(LaboratoryViewModel laboratoryViewModel) throws Exception {

        this.throwIfNull(laboratoryViewModel);

        Laboratory parserLab = Laboratory.parser(laboratoryViewModel);
        Laboratory addedLab = laboratoryRepository.add(parserLab);
        LaboratoryViewModel parserLabViewModel = LaboratoryViewModel.parser(addedLab);

        return parserLabViewModel;
    }

    @Override
    public LaboratoryViewModel update(LaboratoryViewModel newLaboratoryViewModel) throws Exception {

        this.throwIfNull(newLaboratoryViewModel);

        Laboratory newLaboratory = Laboratory.parser(newLaboratoryViewModel);
        Laboratory oldLaboratory = laboratoryRepository.getById(newLaboratoryViewModel.getId());

        this.throwIfNull(oldLaboratory);

        Laboratory updatedLaboratory = laboratoryRepository.update(oldLaboratory, newLaboratory);
        LaboratoryViewModel updatedLaboratoryViewModel = LaboratoryViewModel.parser(updatedLaboratory);

        return updatedLaboratoryViewModel;
    }

    @Override
    public void removeById(int laboratoryId) throws Exception {

        Laboratory laboratory = laboratoryRepository.getById(laboratoryId);

        this.throwIfNull(laboratory);

        laboratoryRepository.remove(laboratory);
    }

    @Override
    public LaboratoryViewModel getById(int laboratoryId) throws Exception {
        Laboratory laboratory = laboratoryRepository.getById(laboratoryId);

        this.throwIfNull(laboratory);

        LaboratoryViewModel laboratoryViewModel = LaboratoryViewModel.parser(laboratory);
        return laboratoryViewModel;
    }

    @Override
    public LaboratoryViewModel findAllByIdle(int pageNumber, int pageSize) {
        // TODO Auto-generated method stub
        return null;
    }

}
