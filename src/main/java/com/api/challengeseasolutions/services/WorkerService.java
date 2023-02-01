package com.api.challengeseasolutions.services;


import com.api.challengeseasolutions.models.WorkerModel;
import com.api.challengeseasolutions.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public final WorkerRepository workerRepository;
    public List<WorkerModel> findAll() {
        return workerRepository.findAll();
    }

    public boolean existsByCpf(String cpf) {
        return workerRepository.existsByCpf(cpf);

    }

    @Transactional
    public WorkerModel save(WorkerModel workerModel){
        return workerRepository.save(workerModel);
    }

    public Optional<WorkerModel> findById(Long id) {
        return workerRepository.findById(id);
    }
@Transactional
    public void delete(WorkerModel workerModel) {
    workerRepository.delete(workerModel);
    }
}
