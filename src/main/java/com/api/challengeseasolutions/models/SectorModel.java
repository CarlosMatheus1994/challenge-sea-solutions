package com.api.challengeseasolutions.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_SECTOR")
public class SectorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String sectorName;


    @Column(unique = true)
    @OneToMany(mappedBy = "sectorName" , cascade = CascadeType.ALL)
    private List<JobModel> jobModels;
    public long getId() {
        return id;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

}

