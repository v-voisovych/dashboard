package com.rogers.dashboard.model.dto;

import com.rogers.dashboard.model.v2.TestStepResult;
import com.rogers.dashboard.model.enums.Status;

public class TestStepResultDTO {

    private String callId;
    private String commandName;
    private String exception;
    private Status status;
    private String startedOn;
    private String finishedOn;

    public TestStepResultDTO(TestStepResult testStepResult) {
        callId = testStepResult.getCallId();
        commandName = testStepResult.getStepName();
        status = testStepResult.getStatus();
        startedOn = testStepResult.getStartedOn();
        finishedOn = testStepResult.getFinishedOn();
    }

    public String getCallId() {
        return callId;
    }

    public void setCallId(String callId) {
        this.callId = callId;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
        return "TestStepResultDTO{" +
                "callId='" + callId + '\'' +
                ", commandName='" + commandName + '\'' +
                ", exception='" + exception + '\'' +
                ", status=" + status +
                ", startedOn='" + startedOn + '\'' +
                ", finishedOn='" + finishedOn + '\'' +
                '}';
    }
}
