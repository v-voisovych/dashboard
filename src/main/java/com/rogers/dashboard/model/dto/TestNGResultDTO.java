package com.rogers.dashboard.model.dto;

import com.rogers.dashboard.model.enums.Status;

import java.util.Map;

public class TestNGResultDTO {

	private String uuId;
	private String jiraId;
	private Map<String, TestStepResultDTO> testStepResultDTOList;
	private Status status;
	private String videoRecord;
	private String focusVideoRecord;
	private String submittedOn;
	private String startedOn;
	private String finishedOn;

	public String getUuId() {
		return uuId;
	}

	public void setUuId(String uuId) {
		this.uuId = uuId;
	}

	public String getJiraId() {
		return jiraId;
	}

	public void setJiraId(String jiraId) {
		this.jiraId = jiraId;
	}

	public Map<String, TestStepResultDTO> getTestStepResultDTOList() {
		return testStepResultDTOList;
	}

	public void setTestStepResultDTOList(Map<String, TestStepResultDTO> testStepResultDTOList) {
		this.testStepResultDTOList = testStepResultDTOList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		return "TestNGResultDTO{" +
			"uuId='" + uuId + '\'' +
			", jiraId='" + jiraId + '\'' +
			", testStepResultDTOList=" + testStepResultDTOList +
			", status=" + status +
			", videoRecord='" + videoRecord + '\'' +
			", focusVideoRecord='" + focusVideoRecord + '\'' +
			", submittedOn='" + submittedOn + '\'' +
			", startedOn='" + startedOn + '\'' +
			", finishedOn='" + finishedOn + '\'' +
			'}';
	}
}
