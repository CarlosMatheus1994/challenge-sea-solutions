package com.api.challengeseasolutions.controllers;

import com.api.challengeseasolutions.dtos.JobDto;
import com.api.challengeseasolutions.dtos.WorkerDto;
import com.api.challengeseasolutions.models.JobModel;
import com.api.challengeseasolutions.models.SectorModel;
import com.api.challengeseasolutions.models.WorkerModel;
import com.api.challengeseasolutions.services.WorkerService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/worker")
public class WorkerController {

    final WorkerService workerService;

    public WorkerController(WorkerService workerService){
        this.workerService = workerService;
    }

    @GetMapping
    public ResponseEntity<List<WorkerModel>> getAllWorkers(){
        return ResponseEntity.status(HttpStatus.OK).body(workerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneWorker(@PathVariable(value = "id") Long id){
        Optional<WorkerModel> workerModelOptional = workerService.findById(id);
        if(!workerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Worker not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(workerModelOptional.get());
    }

    @PostMapping
    public ResponseEntity<Object> createdWorker(@RequestBody @Valid WorkerDto workerDto) {
        if(workerService.existsByCpf(workerDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF is already in use!");
        }
        var workerModel = new WorkerModel();
        BeanUtils.copyProperties(workerDto, workerModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(workerService.save(workerModel));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateWorker(@PathVariable(value = "id")Long id,
                                            @RequestBody @Valid WorkerDto workerDto){
        Optional<WorkerModel> workerModelOptional = workerService.findById(id);
        if(!workerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Worker not found.");
        }
        if(workerService.existsByCpf(workerDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: CPF is already in use!");
        }
        var workerModel = new WorkerModel();
        BeanUtils.copyProperties(workerDto, workerModel);
        workerModel.setId(workerModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(workerService.save(workerModel));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWorker(@PathVariable(value = "id")Long id){
        Optional<WorkerModel> workerModelOptional = workerService.findById(id);
        if(!workerModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Worker not found.");
        }
        workerService.delete(workerModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Worker deleted successfully");
    }
}
