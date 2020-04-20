package models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class ChangeHistory {
    private int changeHistoryId;
    private Timestamp changeHistoryDate;
    private int changeHistoryUserId;
    private String changeHistoryInfo;
    private Users usersByChangeHistoryUserId;

    @Id
    @Column(name = "ChangeHistoryId", nullable = false)
    public int getChangeHistoryId() {
        return changeHistoryId;
    }

    public void setChangeHistoryId(int changeHistoryId) {
        this.changeHistoryId = changeHistoryId;
    }

    @Basic
    @Column(name = "ChangeHistoryDate", nullable = true)
    public Timestamp getChangeHistoryDate() {
        return changeHistoryDate;
    }

    public void setChangeHistoryDate(Timestamp changeHistoryDate) {
        this.changeHistoryDate = changeHistoryDate;
    }

    @Basic
    @Column(name = "ChangeHistoryUserId", nullable = false)
    public int getChangeHistoryUserId() {
        return changeHistoryUserId;
    }

    public void setChangeHistoryUserId(int changeHistoryUserId) {
        this.changeHistoryUserId = changeHistoryUserId;
    }

    @Basic
    @Column(name = "ChangeHistoryInfo", nullable = true, length = 2147483647)
    public String getChangeHistoryInfo() {
        return changeHistoryInfo;
    }

    public void setChangeHistoryInfo(String changeHistoryInfo) {
        this.changeHistoryInfo = changeHistoryInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeHistory that = (ChangeHistory) o;

        if (changeHistoryId != that.changeHistoryId) return false;
        if (changeHistoryUserId != that.changeHistoryUserId) return false;
        if (changeHistoryDate != null ? !changeHistoryDate.equals(that.changeHistoryDate) : that.changeHistoryDate != null)
            return false;
        if (changeHistoryInfo != null ? !changeHistoryInfo.equals(that.changeHistoryInfo) : that.changeHistoryInfo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = changeHistoryId;
        result = 31 * result + (changeHistoryDate != null ? changeHistoryDate.hashCode() : 0);
        result = 31 * result + changeHistoryUserId;
        result = 31 * result + (changeHistoryInfo != null ? changeHistoryInfo.hashCode() : 0);
        return result;
    }
}
