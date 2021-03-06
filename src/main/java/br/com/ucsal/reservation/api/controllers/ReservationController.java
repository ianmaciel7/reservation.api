package br.com.ucsal.reservation.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ucsal.reservation.api.inputModels.ReservationInputModel;
import br.com.ucsal.reservation.api.models.auth.Role;
import br.com.ucsal.reservation.api.services.ReservationService;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;
import br.com.ucsal.reservation.api.viewModels.ReservationViewModel;
import br.com.ucsal.reservation.api.viewModels.ReservationViewModel;

@RestController
@RequestMapping(path = "/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Secured(Role.ADMIN)
    @GetMapping("/find/{reservationId}")
    public ResponseEntity<ReservationViewModel> findById(@PathVariable("reservationId") int reservationId)
            throws Exception {

        ReservationViewModel reservationViewModel = reservationService.findById(reservationId);
        return new ResponseEntity<ReservationViewModel>(reservationViewModel, HttpStatus.OK);
    }

    @Secured(Role.ADMIN)
    @PostMapping("/add")
    public ResponseEntity<ReservationViewModel> add(@RequestBody ReservationInputModel newReservationInputModel)
            throws Exception {

        ReservationViewModel laboratoryViewModel = reservationService.add(newReservationInputModel);
        return new ResponseEntity<ReservationViewModel>(laboratoryViewModel, HttpStatus.CREATED);

    }

    @Secured(Role.ADMIN)
    @PutMapping("/update")
    public ResponseEntity<ReservationViewModel> update(@RequestBody ReservationInputModel newReservationInputModel)
            throws Exception {

        ReservationViewModel laboratoryViewModel = reservationService.update(newReservationInputModel);
        return new ResponseEntity<ReservationViewModel>(laboratoryViewModel, HttpStatus.CREATED);

    }

    @Secured(Role.ADMIN)
    @DeleteMapping("/remove/{laboratoryId}")
    public ResponseEntity<Void> removeById(@PathVariable("laboratoryId") int laboratoryId) throws Exception {

        reservationService.removeById(laboratoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
}
