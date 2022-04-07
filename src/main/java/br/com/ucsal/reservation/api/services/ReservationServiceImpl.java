package br.com.ucsal.reservation.api.services;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ucsal.reservation.api.inputModels.ReservationInputModel;
import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.models.persistence.Reservation;
import br.com.ucsal.reservation.api.models.persistence.User;
import br.com.ucsal.reservation.api.repositories.LaboratoryRepository;
import br.com.ucsal.reservation.api.repositories.ReservationRepository;
import br.com.ucsal.reservation.api.repositories.UserRepository;
import br.com.ucsal.reservation.api.viewModels.ReservationViewModel;

public class ReservationServiceImpl extends BaseService implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ReservationViewModel add(ReservationInputModel reservationInputModel) throws Exception {

        this.throwIfNull(reservationInputModel);
        Laboratory laboratory = this.tryGetLaboratory(reservationInputModel.getLaboratoryId());
        User requester = this.tryGetUser(reservationInputModel.getRequesterId());

        Reservation reservation = Reservation.parser(reservationInputModel, laboratory, requester);
        Reservation addedReservation = reservationRepository.add(reservation);
        ReservationViewModel addedReservationViewModel = ReservationViewModel.parser(addedReservation);
        return addedReservationViewModel;
    }

    @Override
    public ReservationViewModel update(ReservationInputModel newReservationInputModel) throws Exception {

        Reservation oldReservation = this.tryGetReservation(newReservationInputModel.getId());
        Laboratory laboratory = this.tryGetLaboratory(newReservationInputModel.getId());
        User requester = this.tryGetUser(newReservationInputModel.getRequesterId());

        Reservation newReservation = Reservation.parser(newReservationInputModel, laboratory, requester);

        Reservation reservation = reservationRepository.update(oldReservation, newReservation);
        ReservationViewModel reservationViewModel = ReservationViewModel.parser(reservation);

        return reservationViewModel;
    }

    @Override
    public void removeById(int reservationId) throws Exception {
        Reservation reservation = this.tryGetReservation(reservationId);

        reservationRepository.remove(reservation);
    }

    @Override
    public ReservationViewModel findById(int reservationId) throws Exception {
        Reservation reservation = this.tryGetReservation(reservationId);

        ReservationViewModel reservationViewModel = ReservationViewModel.parser(reservation);
        return reservationViewModel;
    }

    private Laboratory tryGetLaboratory(int laboratoryId) throws Exception {
        Laboratory laboratory = laboratoryRepository.getById(laboratoryId);

        this.throwIfNull(laboratory);

        return laboratory;
    }

    private User tryGetUser(int userId) throws Exception {
        User user = userRepository.findById(userId);

        this.throwIfNull(user);

        return user;
    }

    private Reservation tryGetReservation(int reservationId) throws Exception {
        Reservation reservation = reservationRepository.findById(reservationId);

        this.throwIfNull(reservation);

        return reservation;
    }
}
