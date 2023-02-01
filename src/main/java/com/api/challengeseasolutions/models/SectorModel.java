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

    public JobModel getJobModel() {
        return jobModel;
    }

    public void setJobModel(JobModel jobModel) {
        this.jobModel = jobModel;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobName")
    private JobModel jobModel;

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

