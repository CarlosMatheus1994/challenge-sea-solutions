package com.api.challengeseasolutions.services;

import com.api.challengeseasolutions.models.JobModel;
import com.api.challengeseasolutions.models.SectorModel;
import com.api.challengeseasolutions.repositories.JobRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
public class JobService {

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    final JobRepository jobRepository;

    public Optional<JobModel> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Transactional
    public JobModel save(JobModel jobModel){
        return jobRepository.save(jobModel);
    }
    public boolean existsByjob(String jobName) {
        return jobRepository.existsByjobName(jobName);
    }

    @Transactional
    public void delete(JobModel jobModel) {
        jobRepository.delete(jobModel);

    }
}