package br.com.ucsal.reservation.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ucsal.reservation.api.inputModels.LaboratoryPatchInputModel;
import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.Reservation;
import br.com.ucsal.reservation.api.repositories.LaboratoryRepository;
import br.com.ucsal.reservation.api.repositories.ReservationRepository;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;

@Service
public class LaboratoryServiceImpl extends BaseService implements LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public LaboratoryViewModel add(LaboratoryViewModel laboratoryViewModel) throws Exception {

        this.throwIfNull(laboratoryViewModel);
        Laboratory parserLab = Laboratory.parser(laboratoryViewModel);
        Laboratory addedLab = laboratoryRepository.add(parserLab);
        LaboratoryViewModel parserLabViewModel = LaboratoryViewModel.parser(addedLab);

        return parserLabViewModel;
    }

    @Override
    public LaboratoryViewModel patch(LaboratoryPatchInputModel newLaboratoryPatchInputModel) throws Exception {

        this.throwIfNull(newLaboratoryPatchInputModel);

        Laboratory newLaboratory = Laboratory.parser(newLaboratoryPatchInputModel);
        Laboratory oldLaboratory = laboratoryRepository.findById(newLaboratoryPatchInputModel.getId());

        this.throwIfNull(oldLaboratory);

        Laboratory updatedLaboratory = laboratoryRepository.patch(oldLaboratory, newLaboratory);
        LaboratoryViewModel updatedLaboratoryViewModel = LaboratoryViewModel.parser(updatedLaboratory);

        return updatedLaboratoryViewModel;
    }

    @Override
    public void removeById(int laboratoryId) throws Exception {

        Laboratory laboratory = laboratoryRepository.findById(laboratoryId);

        this.throwIfNull(laboratory);

        laboratoryRepository.remove(laboratory);
    }

    @Override
    public LaboratoryViewModel findById(int laboratoryId) throws Exception {
        Laboratory laboratory = laboratoryRepository.findById(laboratoryId);

        this.throwIfNull(laboratory);

        LaboratoryViewModel laboratoryViewModel = LaboratoryViewModel.parser(laboratory);
        return laboratoryViewModel;
    }

    @Override
    public List<LaboratoryViewModel> findAllByIdle(int pageNumber, int pageSize) throws Exception {

        List<Laboratory> laboratories = laboratoryRepository.findAllByIdle(pageNumber, pageSize);

        this.throwIfNull(laboratories);

        List<LaboratoryViewModel> laboratoriesViewModels = laboratories
                .stream()
                .map(x -> LaboratoryViewModel.parser(x))
                .toList();

        return laboratoriesViewModels;
    }

    @Override
    public List<LaboratoryViewModel> findAll(int pageNumber, int pageSize) throws Exception {
        List<Laboratory> laboratories = laboratoryRepository.findAll(pageNumber, pageSize);

        this.throwIfNull(laboratories);

        List<LaboratoryViewModel> laboratoriesViewModels = laboratories
                .stream()
                .map(x -> LaboratoryViewModel.parser(x))
                .toList();

        return laboratoriesViewModels;
    }
}
