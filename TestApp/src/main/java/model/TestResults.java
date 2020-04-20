package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestResults {
    private int resultId;
    private int sendingId;
    private int taskId;
    private Byte result;
    private String candidatesAnswer;

    @Id
    @Column(name = "ResultId", nullable = false)
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    @Basic
    @Column(name = "SendingId", nullable = false)
    public int getSendingId() {
        return sendingId;
    }

    public void setSendingId(int sendingId) {
        this.sendingId = sendingId;
    }

    @Basic
    @Column(name = "TaskId", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "Result", nullable = true)
    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    @Basic
    @Column(name = "CandidatesAnswer", nullable = true, length = 4000)
    public String getCandidatesAnswer() {
        return candidatesAnswer;
    }

    public void setCandidatesAnswer(String candidatesAnswer) {
        this.candidatesAnswer = candidatesAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestResults that = (TestResults) o;

        if (resultId != that.resultId) return false;
        if (sendingId != that.sendingId) return false;
        if (taskId != that.taskId) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (candidatesAnswer != null ? !candidatesAnswer.equals(that.candidatesAnswer) : that.candidatesAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = resultId;
        result1 = 31 * result1 + sendingId;
        result1 = 31 * result1 + taskId;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (candidatesAnswer != null ? candidatesAnswer.hashCode() : 0);
        return result1;
    }
}
