package com.rogers.dashboard.model.v2;

import com.rogers.dashboard.model.enums.Status;
import com.rogers.dashboard.utill.TimestampUtil;

import java.util.ArrayList;
import java.util.Map;

public class TestNGResult {

    private String uuid;
    private String jobId;
    private String jiraID;
    private Status status;
    private String issueTopic;
    private ArrayList<String> validationResult;
    private Map<String, TestStepResult> resultMap;
    private String resultDescription;
    private String submittedOn;
    private String startedOn;
    private String finishedOn;
    private String videoRecord;
    private String focusVideoRecord;
    private String errorMessage;

    public TestNGResult(String uuid, String jobId, String jiraId, Status status) {
        this.uuid = uuid;
        this.jobId = jobId;
        this.jiraID = jiraId;
        this.status = status;
        this.startedOn = TimestampUtil.timeNow();
    }

    public TestNGResult() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJiraID() {
        return jiraID;
    }

    public void setJiraID(String jiraID) {
        this.jiraID = jiraID;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIssueTopic() {
        return issueTopic;
    }

    public void setIssueTopic(String issueTopic) {
        this.issueTopic = issueTopic;
    }

    public ArrayList<String> getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(ArrayList<String> validationResult) {
        this.validationResult = validationResult;
    }

    public Map<String, TestStepResult> getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map<String, TestStepResult> resultMap) {
        this.resultMap = resultMap;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
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

    public String getVideoRecord() {
        return videoRecord;
    }

    public void setVideoRecord(String videoRecord) {
        this.videoRecord = videoRecord;
    }

    public String getFocusVideoRecord() {
        return focusVideoRecord;
    }

    public void setFocusVideoRecord(String focusVideoRecord) {
        this.focusVideoRecord = focusVideoRecord;
    }

    @Override
    public String toString() {
        return "TestNGResult{" +
                "uuid='" + uuid + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jiraID='" + jiraID + '\'' +
                ", status=" + status +
                ", issueTopic=" + issueTopic +
                ", validationResult=" + validationResult +
                ", resultMap=" + resultMap +
                ", submittedOn='" + submittedOn + '\'' +
                ", startedOn='" + startedOn + '\'' +
                ", finishedOn='" + finishedOn + '\'' +
                ", videoRecord='" + videoRecord + '\'' +
                ", focusVideoRecord='" + focusVideoRecord + '\'' +
                '}';
    }
}
