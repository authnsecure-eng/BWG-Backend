package com.pcmc.bwg.dto;

public class CPCBUpdateRequest {
    private Boolean completed;
    private String ackNumber;
    private String submissionDate;

    public CPCBUpdateRequest() {}

    public Boolean getCompleted() { return completed; }
    public void setCompleted(Boolean completed) { this.completed = completed; }

    public String getAckNumber() { return ackNumber; }
    public void setAckNumber(String ackNumber) { this.ackNumber = ackNumber; }

    public String getSubmissionDate() { return submissionDate; }
    public void setSubmissionDate(String submissionDate) { this.submissionDate = submissionDate; }
}
