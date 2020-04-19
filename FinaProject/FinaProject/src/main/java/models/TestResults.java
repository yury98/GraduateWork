package models;

import javax.persistence.*;

@Entity
public class TestResults {
    private int resultId;
    private Byte result;
    private String candidatesAnswer;
    private PacksSendings packsSendingsBySendingId;
    private Tasks tasksByTaskId;

    @Id
    @Column(name = "ResultId", nullable = false)
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
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
        if (result != null ? !result.equals(that.result) : that.result != null) return false;
        if (candidatesAnswer != null ? !candidatesAnswer.equals(that.candidatesAnswer) : that.candidatesAnswer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = resultId;
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (candidatesAnswer != null ? candidatesAnswer.hashCode() : 0);
        return result1;
    }

    @ManyToOne
    @JoinColumn(name = "SendingId", referencedColumnName = "SendingId", nullable = false)
    public PacksSendings getPacksSendingsBySendingId() {
        return packsSendingsBySendingId;
    }

    public void setPacksSendingsBySendingId(PacksSendings packsSendingsBySendingId) {
        this.packsSendingsBySendingId = packsSendingsBySendingId;
    }

    @ManyToOne
    @JoinColumn(name = "TaskId", referencedColumnName = "TaskId", nullable = false)
    public Tasks getTasksByTaskId() {
        return tasksByTaskId;
    }

    public void setTasksByTaskId(Tasks tasksByTaskId) {
        this.tasksByTaskId = tasksByTaskId;
    }
}
