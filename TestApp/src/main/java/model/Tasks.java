package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Tasks {
    private int taskId;
    private int createdBy;
    private Timestamp creationDate;
    private int schemeId;
    private String taskName;
    private String taskString;
    private String taskImage;
    private String taskAnswer;
    private Integer taskTime;

    @Id
    @Column(name = "TaskId", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "CreatedBy", nullable = false)
    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "CreationDate", nullable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "SchemeId", nullable = false)
    public int getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(int schemeId) {
        this.schemeId = schemeId;
    }

    @Basic
    @Column(name = "TaskName", nullable = true, length = 100)
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "TaskString", nullable = true, length = 4000)
    public String getTaskString() {
        return taskString;
    }

    public void setTaskString(String taskString) {
        this.taskString = taskString;
    }

    @Basic
    @Column(name = "TaskImage", nullable = true, length = 2147483647)
    public String getTaskImage() {
        return taskImage;
    }

    public void setTaskImage(String taskImage) {
        this.taskImage = taskImage;
    }

    @Basic
    @Column(name = "TaskAnswer", nullable = true, length = 4000)
    public String getTaskAnswer() {
        return taskAnswer;
    }

    public void setTaskAnswer(String taskAnswer) {
        this.taskAnswer = taskAnswer;
    }

    @Basic
    @Column(name = "TaskTime", nullable = true)
    public Integer getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(Integer taskTime) {
        this.taskTime = taskTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tasks tasks = (Tasks) o;

        if (taskId != tasks.taskId) return false;
        if (createdBy != tasks.createdBy) return false;
        if (schemeId != tasks.schemeId) return false;
        if (creationDate != null ? !creationDate.equals(tasks.creationDate) : tasks.creationDate != null) return false;
        if (taskName != null ? !taskName.equals(tasks.taskName) : tasks.taskName != null) return false;
        if (taskString != null ? !taskString.equals(tasks.taskString) : tasks.taskString != null) return false;
        if (taskImage != null ? !taskImage.equals(tasks.taskImage) : tasks.taskImage != null) return false;
        if (taskAnswer != null ? !taskAnswer.equals(tasks.taskAnswer) : tasks.taskAnswer != null) return false;
        if (taskTime != null ? !taskTime.equals(tasks.taskTime) : tasks.taskTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + createdBy;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + schemeId;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (taskString != null ? taskString.hashCode() : 0);
        result = 31 * result + (taskImage != null ? taskImage.hashCode() : 0);
        result = 31 * result + (taskAnswer != null ? taskAnswer.hashCode() : 0);
        result = 31 * result + (taskTime != null ? taskTime.hashCode() : 0);
        return result;
    }
}