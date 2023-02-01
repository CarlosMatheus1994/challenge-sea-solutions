package com.api.challengeseasolutions.dtos;

import javax.validation.constraints.NotBlank;

public class JobDto {
    @NotBlank
    private String jobName;

    public String getjobName() {
        return jobName;
    }

    public void setSJobName(String jobName) {
        this.jobName = jobName;
    }
}

