package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Packs {
    private int packId;
    private Timestamp creationDate;
    private String packName;
    private String packDescription;
    private Integer packTime;
    private Users usersByCreatedBy;
    private Collection<PacksSendings> packsSendingsByPackId;
    private Collection<TasksOfPacks> tasksOfPacksByPackId;

    @Id
    @Column(name = "PackId", nullable = false)
    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
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
    @Column(name = "PackName", nullable = true, length = 100)
    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    @Basic
    @Column(name = "PackDescription", nullable = true, length = 1000)
    public String getPackDescription() {
        return packDescription;
    }

    public void setPackDescription(String packDescription) {
        this.packDescription = packDescription;
    }

    @Basic
    @Column(name = "PackTime", nullable = true)
    public Integer getPackTime() {
        return packTime;
    }

    public void setPackTime(Integer packTime) {
        this.packTime = packTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Packs packs = (Packs) o;

        if (packId != packs.packId) return false;
        if (creationDate != null ? !creationDate.equals(packs.creationDate) : packs.creationDate != null) return false;
        if (packName != null ? !packName.equals(packs.packName) : packs.packName != null) return false;
        if (packDescription != null ? !packDescription.equals(packs.packDescription) : packs.packDescription != null)
            return false;
        if (packTime != null ? !packTime.equals(packs.packTime) : packs.packTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packId;
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (packName != null ? packName.hashCode() : 0);
        result = 31 * result + (packDescription != null ? packDescription.hashCode() : 0);
        result = 31 * result + (packTime != null ? packTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CreatedBy", referencedColumnName = "UserId", nullable = false)
    public Users getUsersByCreatedBy() {
        return usersByCreatedBy;
    }

    public void setUsersByCreatedBy(Users usersByCreatedBy) {
        this.usersByCreatedBy = usersByCreatedBy;
    }

    @OneToMany(mappedBy = "packsByPackId")
    public Collection<PacksSendings> getPacksSendingsByPackId() {
        return packsSendingsByPackId;
    }

    public void setPacksSendingsByPackId(Collection<PacksSendings> packsSendingsByPackId) {
        this.packsSendingsByPackId = packsSendingsByPackId;
    }

    @OneToMany(mappedBy = "packsByPackId")
    public Collection<TasksOfPacks> getTasksOfPacksByPackId() {
        return tasksOfPacksByPackId;
    }

    public void setTasksOfPacksByPackId(Collection<TasksOfPacks> tasksOfPacksByPackId) {
        this.tasksOfPacksByPackId = tasksOfPacksByPackId;
    }
}
