package com.api.challengeseasolutions.dtos;

import javax.validation.constraints.NotBlank;

public class WorkerDto {
    @NotBlank
    private String workerName;
    private Integer age;
    private String cpf;

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

