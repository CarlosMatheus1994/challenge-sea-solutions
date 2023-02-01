package com.api.challengeseasolutions.repositories;

import com.api.challengeseasolutions.models.JobModel;
import com.api.challengeseasolutions.models.SectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Id> {


    boolean existsByjobName(String jobName);

    Optional<JobModel> findById(Long id);

    void deleteById(long id);
}
