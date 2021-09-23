package com.rogers.dashboard.model.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ScenarioDTO {

    private String jiraId;
    private String jobId;

    public ScenarioDTO(String jiraId, String jobId) {
        this.jiraId = jiraId;
        this.jobId = jobId;
    }

    public ScenarioDTO(String jiraId) {
        this.jiraId = jiraId;
    }

    public ScenarioDTO() {
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJiraId() {
        return jiraId;
    }

    public void setJiraId(String jiraID) {
        this.jiraId = jiraID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ScenarioDTO that = (ScenarioDTO) o;

        return new EqualsBuilder().append(jiraId, that.jiraId).append(jobId, that.jobId).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(jiraId).append(jobId).toHashCode();
    }

    @Override
    public String toString() {
        return "ScenarioDTO{" +
                "jiraId='" + jiraId + '\'' +
                ", jobId='" + jobId + '\'' +
                '}';
    }
}
