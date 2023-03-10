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

    @ManyToOne
    @JoinColumn(name = "sectorName", nullable = true )
    private SectorModel sectorName;

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
        return sectorName;
    }

    public void setSectorName(SectorModel sectorName) {
        this.sectorName = sectorName;
    }



}



