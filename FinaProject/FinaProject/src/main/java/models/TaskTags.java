package models;

import javax.persistence.*;

@Entity
public class TaskTags {
    private int tagLinkId;
    private int tagId;
    private int taskId;
    private Tags tagsByTagId;
    private Tasks tasksByTaskId;

    @Id
    @Column(name = "TagLinkId", nullable = false)
    public int getTagLinkId() {
        return tagLinkId;
    }

    public void setTagLinkId(int tagLinkId) {
        this.tagLinkId = tagLinkId;
    }

    @Basic
    @Column(name = "TagId", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "TaskId", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskTags taskTags = (TaskTags) o;

        if (tagLinkId != taskTags.tagLinkId) return false;
        if (tagId != taskTags.tagId) return false;
        if (taskId != taskTags.taskId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagLinkId;
        result = 31 * result + tagId;
        result = 31 * result + taskId;
        return result;
    }
}
