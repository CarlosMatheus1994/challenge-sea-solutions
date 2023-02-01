package com.api.challengeseasolutions.repositories;


import com.api.challengeseasolutions.models.SectorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;


@Repository
public interface SectorRepository extends JpaRepository<SectorModel, Id> {
    boolean existsBySectorName(String sectorName);


    Optional<SectorModel> findById(Long id);
}
