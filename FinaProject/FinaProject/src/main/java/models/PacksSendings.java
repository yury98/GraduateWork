package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class PacksSendings {
    private int sendingId;
    private int packId;
    private Timestamp sendingDate;
    private String sendingEmail;
    private Packs packsByPackId;
    private Collection<TestResults> testResultsBySendingId;

    @Id
    @Column(name = "SendingId", nullable = false)
    public int getSendingId() {
        return sendingId;
    }

    public void setSendingId(int sendingId) {
        this.sendingId = sendingId;
    }

    @Basic
    @Column(name = "PackId", nullable = false)
    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    @Basic
    @Column(name = "SendingDate", nullable = true)
    public Timestamp getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Timestamp sendingDate) {
        this.sendingDate = sendingDate;
    }

    @Basic
    @Column(name = "SendingEmail", nullable = true, length = 100)
    public String getSendingEmail() {
        return sendingEmail;
    }

    public void setSendingEmail(String sendingEmail) {
        this.sendingEmail = sendingEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacksSendings that = (PacksSendings) o;

        if (sendingId != that.sendingId) return false;
        if (packId != that.packId) return false;
        if (sendingDate != null ? !sendingDate.equals(that.sendingDate) : that.sendingDate != null) return false;
        if (sendingEmail != null ? !sendingEmail.equals(that.sendingEmail) : that.sendingEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sendingId;
        result = 31 * result + packId;
        result = 31 * result + (sendingDate != null ? sendingDate.hashCode() : 0);
        result = 31 * result + (sendingEmail != null ? sendingEmail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "packsSendingsBySendingId")
    public Collection<TestResults> getTestResultsBySendingId() {
        return testResultsBySendingId;
    }

    public void setTestResultsBySendingId(Collection<TestResults> testResultsBySendingId) {
        this.testResultsBySendingId = testResultsBySendingId;
    }
}
