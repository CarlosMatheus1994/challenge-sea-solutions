package com.api.challengeseasolutions.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TB_JOB")
public class JobModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String jobName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sectorName")
    private SectorModel sectorModel;

    public String getJobName() {
        return jobName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public long getId() {
        return id;
    }

    public SectorModel getSectorName() {
        return sectorModel;
    }

    public void setSectorName(SectorModel sectorName) {
        this.sectorModel = sectorName;
    }

}



