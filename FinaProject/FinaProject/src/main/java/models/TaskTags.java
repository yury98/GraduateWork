package models;

import javax.persistence.*;

@Entity
public class TaskTags {
    private int tagLinkId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskTags taskTags = (TaskTags) o;

        if (tagLinkId != taskTags.tagLinkId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagLinkId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TagId", referencedColumnName = "TagId", nullable = false)
    public Tags getTagsByTagId() {
        return tagsByTagId;
    }

    public void setTagsByTagId(Tags tagsByTagId) {
        this.tagsByTagId = tagsByTagId;
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
