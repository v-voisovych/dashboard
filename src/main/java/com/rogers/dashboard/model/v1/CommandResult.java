package com.rogers.dashboard.model.v1;

public class CommandResult {
    private String commandId;
    private String before;
    private String after;
    private String value;
    private String startedOn;
    private String finishedOn;

    public CommandResult() {
    }

    public CommandResult(String value) {
        this.value = value;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }
}
