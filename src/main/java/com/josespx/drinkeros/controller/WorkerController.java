package com.josespx.drinkeros.controller;

import com.josespx.drinkeros.model.Worker;
import com.josespx.drinkeros.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class WorkerController {

    private WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @RequestMapping(value = "/workers", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<Worker> save(@Valid @RequestBody Worker worker, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.workerService.save(worker);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
        Worker worker = this.workerService.findById(id);
        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(worker, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = this.workerService.findAll();
        if (workerList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(workerList, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.PATCH, headers = "Accept=application/json")
    public ResponseEntity<Worker> update(@PathVariable("id") Long id, @RequestBody Worker worker) {

        Worker workerToUpdate = this.workerService.findById(id);
        if (workerToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        workerToUpdate.setName(worker.getName());
        workerToUpdate.setLastName(worker.getLastName());
        workerToUpdate.setDni(worker.getDni());
        workerToUpdate.setAddress(worker.getAddress());
        workerToUpdate.setPhone(worker.getPhone());
        workerToUpdate.setEmail(worker.getEmail());

        this.workerService.save(workerToUpdate);
        return new ResponseEntity<>(workerToUpdate, HttpStatus.OK);
    }

    @RequestMapping(value = "/workers/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Worker> deleteById(@PathVariable("id") Long id) {
        Worker worker = this.workerService.findById(id);
        if (worker == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        worker.setEliminated("1");
        this.workerService.save(worker);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }


}
