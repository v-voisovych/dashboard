package com.rogers.dashboard.model.v1;

import java.util.List;

public class Message {
    private List<CommandResult> results;

    public Message() {
    }

    public Message(List<CommandResult> results) {
        this.results = results;
    }

    public List<CommandResult> getResults() {
        return results;
    }

    public void setResults(List<CommandResult> results) {
        this.results = results;
    }
}
