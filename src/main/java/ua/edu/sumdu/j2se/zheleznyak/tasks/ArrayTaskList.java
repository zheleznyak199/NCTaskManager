package ua.edu.sumdu.j2se.zheleznyak.tasks;

import java.util.Arrays;
import java.util.LinkedList;

public class ArrayTaskList {
    private Task [] tasks = new Task[0];
    public void  add (Task task){
        Task[] temp = tasks;
        tasks = new Task[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            tasks[i] = temp[i];
        }
        tasks[tasks.length - 1] = task;
    }
    public boolean remove (Task task){
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == task) {
                Task[] temp = tasks;
                tasks = new Task[temp.length - 1];
                for (int j = 0; j < i; j++) {
                    tasks[j] = temp[j];
                }
                for (int j = i + 1; j < temp.length; j++) {
                    tasks[j - 1] = temp[j];
                }
                return true;
            }
        }
        return false;
    }

    public int  size(){
        return tasks.length;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayTaskList that = (ArrayTaskList) o;
        return Arrays.equals(tasks, that.tasks);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(tasks);
    }

    public Task getTask(int index){
        return tasks[index];
    }
    public ArrayTaskList incoming (int from, int to){
            ArrayTaskList arrayTaskList = new ArrayTaskList();
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].nextTimeAfter(from) != -1
                    && tasks[i].getEndTime() <= to) {
                if (tasks[i].isActive()) {
                    arrayTaskList.add(tasks[i]);
                }
            }
        }
        return arrayTaskList;

    }
}
