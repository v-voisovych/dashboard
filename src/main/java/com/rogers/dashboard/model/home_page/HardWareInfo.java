package com.rogers.dashboard.model.home_page;

public class HardWareInfo {

    private String name;
    private String os;
    private String hardWareStatus;
    private Details details;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHardWareStatus() {
        return hardWareStatus;
    }

    public void setHardWareStatus(String hardWareStatus) {
        this.hardWareStatus = hardWareStatus;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }
}
