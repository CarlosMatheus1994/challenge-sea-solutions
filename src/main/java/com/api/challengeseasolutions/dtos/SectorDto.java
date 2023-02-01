package com.api.challengeseasolutions.dtos;

import javax.validation.constraints.NotBlank;

public class SectorDto {
    @NotBlank
    private String sectorName;

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
