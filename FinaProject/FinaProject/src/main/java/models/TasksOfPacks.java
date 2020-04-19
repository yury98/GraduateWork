package models;

import javax.persistence.*;

@Entity
public class TasksOfPacks {
    private int tasksOfPacksId;
    private Tasks tasksByTaskId;
    private Packs packsByPackId;

    @Id
    @Column(name = "TasksOfPacksId", nullable = false)
    public int getTasksOfPacksId() {
        return tasksOfPacksId;
    }

    public void setTasksOfPacksId(int tasksOfPacksId) {
        this.tasksOfPacksId = tasksOfPacksId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksOfPacks that = (TasksOfPacks) o;

        if (tasksOfPacksId != that.tasksOfPacksId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tasksOfPacksId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TaskId", referencedColumnName = "TaskId", nullable = false)
    public Tasks getTasksByTaskId() {
        return tasksByTaskId;
    }

    public void setTasksByTaskId(Tasks tasksByTaskId) {
        this.tasksByTaskId = tasksByTaskId;
    }

    @ManyToOne
    @JoinColumn(name = "PackId", referencedColumnName = "PackId", nullable = false)
    public Packs getPacksByPackId() {
        return packsByPackId;
    }

    public void setPacksByPackId(Packs packsByPackId) {
        this.packsByPackId = packsByPackId;
    }
}
