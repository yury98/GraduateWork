package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TasksOfPacks {
    private int tasksOfPacksId;
    private int taskId;
    private int packId;

    @Id
    @Column(name = "TasksOfPacksId", nullable = false)
    public int getTasksOfPacksId() {
        return tasksOfPacksId;
    }

    public void setTasksOfPacksId(int tasksOfPacksId) {
        this.tasksOfPacksId = tasksOfPacksId;
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
    @Column(name = "PackId", nullable = false)
    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksOfPacks that = (TasksOfPacks) o;

        if (tasksOfPacksId != that.tasksOfPacksId) return false;
        if (taskId != that.taskId) return false;
        if (packId != that.packId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tasksOfPacksId;
        result = 31 * result + taskId;
        result = 31 * result + packId;
        return result;
    }
}
