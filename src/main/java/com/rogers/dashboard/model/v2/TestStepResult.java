package com.rogers.dashboard.model.v2;

import com.rogers.dashboard.model.dto.TestStepResultDTO;
import com.rogers.dashboard.model.enums.Status;


public class TestStepResult {

	private String callId;
	private String stepName;
	private String exception;
	private Status status;
	private String startedOn;
	private String finishedOn;

	public TestStepResult(TestStepResultDTO testStepResultDTO) {
		this.callId = testStepResultDTO.getCallId();
		this.stepName = testStepResultDTO.getCommandName();
		this.exception = testStepResultDTO.getException();
		this.status = testStepResultDTO.getStatus();
		this.startedOn = testStepResultDTO.getStartedOn();
		this.finishedOn = testStepResultDTO.getFinishedOn();
	}

	public TestStepResult() {
	}

	public TestStepResult(String stepName) {
		this.stepName = stepName;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
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
		return "TestStepResult{" +
			"callId='" + callId + '\'' +
			", commandName='" + stepName + '\'' +
			", exception='" + exception + '\'' +
			", status=" + status +
			", startedOn='" + startedOn + '\'' +
			", finishedOn='" + finishedOn + '\'' +
			'}';
	}
}
