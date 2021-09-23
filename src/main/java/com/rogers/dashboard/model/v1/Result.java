package com.rogers.dashboard.model.v1;


import com.rogers.dashboard.model.enums.Status;

public class Result {

    private CallID callId;
    private String commandName;
    private String value;
    private Message message;
    private String exception;
    private String type;
    private String videoFormat;
    private Status status;
    private String submittedOn;
    private String startedOn;
    private String finishedOn;


    @Override
    public String toString() {
        return "Result{" +
                "callId=" + callId +
                ", commandName='" + commandName + '\'' +
                ", value='" + value + '\'' +
                ", message=" + message +
                ", type='" + type + '\'' +
                ", videoFormat='" + videoFormat + '\'' +
                ", status=" + status +
                ", submittedOn='" + submittedOn + '\'' +
                ", startedOn='" + startedOn + '\'' +
                ", finishedOn='" + finishedOn + '\'' +
                '}';
    }

    public CallID getCallId() {
        return callId;
    }

    public void setCallId(CallID callId) {
        this.callId = callId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
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

    public String getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(String submittedOn) {
        this.submittedOn = submittedOn;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
