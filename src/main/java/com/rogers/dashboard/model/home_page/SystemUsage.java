package com.rogers.dashboard.model.home_page;

public class SystemUsage {
    private String totalRAM;
    private String availableRAM;
    private String usageRAM;
    private String cpuUsage;
    private String errorMessage;

    public String getTotalRAM() {
        return totalRAM;
    }

    public void setTotalRAM(String totalRAM) {
        this.totalRAM = totalRAM;
    }

    public String getAvailableRAM() {
        return availableRAM;
    }

    public void setAvailableRAM(String availableRAM) {
        this.availableRAM = availableRAM;
    }

    public String getUsageRAM() {
        return usageRAM;
    }

    public void setUsageRAM(String usageRAM) {
        this.usageRAM = usageRAM;
    }

    public String getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
