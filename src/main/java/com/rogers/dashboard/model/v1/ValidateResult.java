package com.rogers.dashboard.model.v1;

public class ValidateResult {
    private String commandId;
    private String commandName;
    private String expectedResult;
    private String actualResult;
    private String before;
    private String after;
    private String validation;

    public ValidateResult() {
    }

    public ValidateResult(String commandId, String commandName, String expectedResult, String actualResult, String before, String after, String validation) {
        this.commandId = commandId;
        this.commandName = commandName;
        this.expectedResult = expectedResult;
        this.actualResult = actualResult;
        this.before = before;
        this.after = after;
        this.validation = validation;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
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

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "ValidateResult{" +
                "commandId='" + commandId + '\'' +
                ", commandName='" + commandName + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", actualResult='" + actualResult + '\'' +
                ", before='" + before + '\'' +
                ", after='" + after + '\'' +
                ", validation='" + validation + '\'' +
                '}';
    }
}
