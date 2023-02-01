package com.api.challengeseasolutions.services;

import com.api.challengeseasolutions.models.SectorModel;
import com.api.challengeseasolutions.repositories.SectorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
public class SectorService {

    public final SectorRepository sectorRepository;

    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }
    @Transactional
    public SectorModel save(SectorModel sectorModel){
        return sectorRepository.save(sectorModel);
    }

    public boolean existsBySectorName(String sectorName){
        return sectorRepository.existsBySectorName(sectorName);
    }

    public List<SectorModel> findAll() {
        return sectorRepository.findAll();
    }

    public Optional<SectorModel> findById(Long id) {
        return sectorRepository.findById(id);
    }
    @Transactional
    public void delete(SectorModel sectorModel) {
        sectorRepository.delete(sectorModel);
    }
}
