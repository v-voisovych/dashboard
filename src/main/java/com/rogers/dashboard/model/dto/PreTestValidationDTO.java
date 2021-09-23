package com.rogers.dashboard.model.dto;

import com.rogers.dashboard.model.enums.Status;

public class PreTestValidationDTO {

    private Status status;
    private String description;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
