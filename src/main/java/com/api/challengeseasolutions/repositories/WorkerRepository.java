package com.api.challengeseasolutions.repositories;

import com.api.challengeseasolutions.models.WorkerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Id> {
    boolean existsByWorkerName(String workerName);

   Optional<WorkerModel> findById(Long id);

    boolean existsByCpf(String cpf);
}