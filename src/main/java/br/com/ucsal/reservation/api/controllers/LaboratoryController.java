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

import br.com.ucsal.reservation.api.inputModels.LaboratoryPatchInputModel;
import br.com.ucsal.reservation.api.models.auth.Role;
import br.com.ucsal.reservation.api.models.persistence.Laboratory;
import br.com.ucsal.reservation.api.services.LaboratoryService;
import br.com.ucsal.reservation.api.viewModels.LaboratoryViewModel;

@RestController
@RequestMapping(path = "/laboratories")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    @Secured(Role.ADMIN)
    @GetMapping("/find/{laboratoryId}")
    public ResponseEntity<LaboratoryViewModel> findById(@PathVariable("laboratoryId") int laboratoryId) {
        try {
            LaboratoryViewModel laboratoryViewModel = laboratoryService.findById(laboratoryId);
            return new ResponseEntity<LaboratoryViewModel>(laboratoryViewModel, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured(Role.ADMIN)
    @PostMapping("/add")
    public ResponseEntity<LaboratoryViewModel> add(@RequestBody LaboratoryViewModel newLaboratoryViewModel) {
        try {
            LaboratoryViewModel laboratoryViewModel = laboratoryService.add(newLaboratoryViewModel);
            return new ResponseEntity<LaboratoryViewModel>(laboratoryViewModel, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured(Role.ADMIN)
    @PutMapping("/patch")
    public ResponseEntity<LaboratoryViewModel> patch(
            @RequestBody LaboratoryPatchInputModel newLaboratoryPatchInputModel) {
        try {
            LaboratoryViewModel laboratoryViewModel = laboratoryService.patch(newLaboratoryPatchInputModel);
            return new ResponseEntity<LaboratoryViewModel>(laboratoryViewModel, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured(Role.ADMIN)
    @DeleteMapping("/remove/{laboratoryId}")
    public ResponseEntity<Void> removeById(@PathVariable("laboratoryId") int laboratoryId) {
        try {
            laboratoryService.removeById(laboratoryId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Secured(Role.ADMIN)
    @GetMapping("/list/idle")
    public ResponseEntity<List<LaboratoryViewModel>> findAllByIdle(@RequestParam int pageNumber,
            @RequestParam int pageSize) {
        try {
            List<LaboratoryViewModel> laboratories = laboratoryService.findAllByIdle(pageNumber, pageSize);
            return new ResponseEntity<List<LaboratoryViewModel>>(laboratories, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
