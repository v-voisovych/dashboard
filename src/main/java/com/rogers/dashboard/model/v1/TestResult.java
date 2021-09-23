package com.rogers.dashboard.model.v1;

import com.rogers.dashboard.model.enums.Status;

import java.util.List;

public class TestResult {
    private String uuid;
    private String jobId;
    private String jiraID;
    private String deviceId;
    private String propertyId;
    private String scenarioName;
    private List<Result> resultList;
    private Status status;
    private List<ValidateResult> validateResultCollection;
    private Exception validationException;
    private String submittedOn;
    private String startedOn;
    private String finishedOn;
    private String videoRecord;
    private String focusVideoRecord;


    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ValidateResult> getValidateResultCollection() {
        return validateResultCollection;
    }

    public void setValidateResultCollection(List<ValidateResult> validateResultCollection) {
        this.validateResultCollection = validateResultCollection;
    }

    public String getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }

    public String getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(String submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(String startedOn) {
        this.startedOn = startedOn;
    }

    public String getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(String finishedOn) {
        this.finishedOn = finishedOn;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "uuid='" + uuid + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", resultList=" + resultList +
                ", status=" + status +
                ", validateResultCollection=" + validateResultCollection +
                ", scenarioName='" + scenarioName + '\'' +
                ", submittedOn='" + submittedOn + '\'' +
                ", startedOn='" + startedOn + '\'' +
                ", finishedOn='" + finishedOn + '\'' +
                '}';
    }

    public String getVideoRecord() {
        return this.videoRecord;
    }

    public void setVideoRecord(String videoRecord) {
        this.videoRecord = videoRecord;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Exception getValidationException() {
        return validationException;
    }

    public void setValidationException(Exception validationException) {
        this.validationException = validationException;
    }

    public String getJiraID() {
        return jiraID;
    }

    public void setJiraID(String jiraID) {
        this.jiraID = jiraID;
    }

    public String getFocusVideoRecord() {
        return focusVideoRecord;
    }

    public void setFocusVideoRecord(String focusVideoRecord) {
        this.focusVideoRecord = focusVideoRecord;
    }
}
