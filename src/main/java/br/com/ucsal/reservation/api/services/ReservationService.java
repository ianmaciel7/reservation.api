package br.com.ucsal.reservation.api.services;

import br.com.ucsal.reservation.api.inputModels.ReservationInputModel;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;
import br.com.ucsal.reservation.api.viewModels.ReservationViewModel;

public interface ReservationService {

    public ReservationViewModel add(ReservationInputModel reservationInputModel) throws Exception;

    public ReservationViewModel update(ReservationInputModel newReservationInputModel) throws Exception;

    public void removeById(int reservationId) throws Exception;

    public ReservationViewModel findById(int reservationId) throws Exception;

}
