package com.api.challengeseasolutions.controllers;

import com.api.challengeseasolutions.dtos.JobDto;
import com.api.challengeseasolutions.dtos.SectorDto;
import com.api.challengeseasolutions.models.JobModel;
import com.api.challengeseasolutions.models.SectorModel;
import com.api.challengeseasolutions.repositories.JobRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.challengeseasolutions.services.JobService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/jobs")
public class JobController {

 public final JobRepository jobRepository;
 public final JobService jobService;

    public JobController(JobRepository jobRepository, JobService jobService) {
        this.jobRepository = jobRepository;
        this.jobService = jobService;
    }

    @GetMapping
    public List<JobModel> getAllJobs() {
        return jobRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> createdJob(@RequestBody @Valid JobDto jobDto) {
        if(jobService.existsByjob(jobDto.getjobName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict:Job name is already in use!");
        }
        var jobModel = new JobModel();
        BeanUtils.copyProperties(jobDto, jobModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.save(jobModel));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneJob(@PathVariable(value = "id") Long id){
        Optional<JobModel> jobModelOptional = jobService.findById(id);
        if(!jobModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("job not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(jobModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateJob(@PathVariable(value = "id")Long id,
                                               @RequestBody @Valid JobDto jobDto){
        Optional<JobModel> jobModelOptional = jobService.findById(id);
        if(!jobModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found.");
        }
        var jobModel = new JobModel();
        BeanUtils.copyProperties(jobDto, jobModel);
        jobModel.setId(jobModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(jobService.save(jobModel));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJob(@PathVariable(value = "id")Long id){
        Optional<JobModel> jobModelOptional = jobService.findById(id);
        if(!jobModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job not found.");
        }
        jobService.delete(jobModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Job deleted successfully");
    }

}