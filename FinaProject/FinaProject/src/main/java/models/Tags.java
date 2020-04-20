package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Tags {
    private int tagId;
    private String tagName;
    private Timestamp creationDate;
    private int createdBy;
    private Users usersByCreatedBy;
    private Collection<TaskTags> taskTagsByTagId;

    @Id
    @Column(name = "TagId", nullable = false)
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "TagName", nullable = false, length = 45)
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
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
    @Column(name = "CreatedBy", nullable = false)
    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tags tags = (Tags) o;

        if (tagId != tags.tagId) return false;
        if (createdBy != tags.createdBy) return false;
        if (tagName != null ? !tagName.equals(tags.tagName) : tags.tagName != null) return false;
        if (creationDate != null ? !creationDate.equals(tags.creationDate) : tags.creationDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagId;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + createdBy;
        return result;
    }

    @OneToMany(mappedBy = "tagsByTagId")
    public Collection<TaskTags> getTaskTagsByTagId() {
        return taskTagsByTagId;
    }

    public void setTaskTagsByTagId(Collection<TaskTags> taskTagsByTagId) {
        this.taskTagsByTagId = taskTagsByTagId;
    }
}
