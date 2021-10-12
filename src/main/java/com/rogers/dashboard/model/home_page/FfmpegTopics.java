package com.rogers.dashboard.model.home_page;

public class FfmpegTopics {
    private String command;
    private String response;
    private String ffmpegLogsCommand;
    private String ffmpegLogsResult;
    private String errorMessage;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getFfmpegLogsCommand() {
        return ffmpegLogsCommand;
    }

    public void setFfmpegLogsCommand(String ffmpegLogsCommand) {
        this.ffmpegLogsCommand = ffmpegLogsCommand;
    }

    public String getFfmpegLogsResult() {
        return ffmpegLogsResult;
    }

    public void setFfmpegLogsResult(String ffmpegLogsResult) {
        this.ffmpegLogsResult = ffmpegLogsResult;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
