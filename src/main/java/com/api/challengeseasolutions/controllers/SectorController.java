package com.api.challengeseasolutions.controllers;

import com.api.challengeseasolutions.dtos.SectorDto;
import com.api.challengeseasolutions.models.SectorModel;
import com.api.challengeseasolutions.repositories.JobRepository;
import com.api.challengeseasolutions.services.SectorService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/sectors")
public class SectorController {

    final SectorService sectorService;
    private final JobRepository jobRepository;

    public SectorController(SectorService sectorService,
                            JobRepository jobRepository){
        this.sectorService = sectorService;
        this.jobRepository = jobRepository;
    }

    @PostMapping
    public ResponseEntity<Object> createdSector(@RequestBody @Valid SectorDto sectorDto) {
        if(sectorService.existsBySectorName(sectorDto.getSectorName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Sector name is already in use!");
        }
        var sectorModel = new SectorModel();
        BeanUtils.copyProperties(sectorDto, sectorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectorService.save(sectorModel));

    }

    @GetMapping
    public ResponseEntity<List<SectorModel>> getAllSectors(){
        return ResponseEntity.status(HttpStatus.OK).body(sectorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneSector(@PathVariable(value = "id") Long id){
        Optional<SectorModel> sectorModelOptional = sectorService.findById(id);
        if(!sectorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector name not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(sectorModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSector(@PathVariable(value = "id")Long id){
        Optional<SectorModel> sectorModelOptional = sectorService.findById(id);
        if(!sectorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector not found.");
        }
        sectorService.delete(sectorModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Sector deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateSector(@PathVariable(value = "id")Long id,
                                               @RequestBody @Valid SectorDto sectorDto){
        Optional<SectorModel> sectorModelOptional = sectorService.findById(id);
        if(!sectorModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector not found.");
        }
        var sectorModel = new SectorModel();
        BeanUtils.copyProperties(sectorDto, sectorModel);
        sectorModel.setId(sectorModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(sectorService.save(sectorModel));

    }

}