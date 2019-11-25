package ua.edu.sumdu.j2se.zheleznyak.tasks;

import java.util.Objects;

public class Task {
    private int Time;
    private String Title;
    private boolean Active;
    private boolean Repeated;
    private int StartTime;
    private int EndTime;
    private int RepeatInterval = 0;


    public Task (String title, int time)  throws IllegalArgumentException{
        this.Title = title;
        this.Time = time;
        StartTime = time;
        EndTime = time;
        Repeated = false;
        if (Time < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Task(String title, int start, int end, int interval) throws IllegalArgumentException {
    this.Title = title;
    this.StartTime = start;
    this.EndTime = end;
    this.RepeatInterval = interval;
    Time = StartTime;
    Repeated = true;
        if (start < 0 && end < 0 && interval < 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getTime() {
        return Time;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setTime(int time) {
        Time = time;
        this.Time = time;
        StartTime = time;
        EndTime = time;
        Repeated = false;
        RepeatInterval = 0;

    }

    public void setActive(boolean active) {
        Active = active;
    }

    public boolean isActive() {
        return false;
    }

    public int getStartTime() {
        return StartTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public int getRepeatInterval() {
        return RepeatInterval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Time == task.Time &&
                Active == task.Active &&
                Repeated == task.Repeated &&
                StartTime == task.StartTime &&
                EndTime == task.EndTime &&
                RepeatInterval == task.RepeatInterval &&
                Title.equals(task.Title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Time, Title, Active, Repeated, StartTime, EndTime, RepeatInterval);
    }

    public void setTime(int start, int end, int interval) {
        this.StartTime = start;
        this.EndTime = end;
        this.RepeatInterval = interval;
        Time = StartTime;
        Repeated = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Time=" + Time +
                ", Title='" + Title + '\'' +
                ", Active=" + Active +
                ", Repeated=" + Repeated +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", RepeatInterval=" + RepeatInterval +
                '}';
    }

    public boolean isRepeated() {
        return Repeated;
    }

    public int nextTimeAfter(final int current) {
        if (current >= EndTime || current + RepeatInterval >= EndTime
                || !Active) {
            return -1;
        }

        if (!Repeated) {
            return Time;
        }

        int test = StartTime;
        for (int i = StartTime; i <= current; i += RepeatInterval) {
            if (i < EndTime - RepeatInterval) {
                test += RepeatInterval;
            }
        }
        return test;
    }
}





