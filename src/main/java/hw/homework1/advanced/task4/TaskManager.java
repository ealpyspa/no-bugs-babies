package hw.homework1.advanced.task4;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskArrayList;

    public TaskManager() {
        this.taskArrayList = new ArrayList<>();
    }

    public void addTaskToArrayList(Task task) {
        taskArrayList.add(task);
    }

    public void removeTaskFromArrayList(Task task) {
        taskArrayList.remove(task);
    }

    public void sortArrayList() {
        taskArrayList.sort((t1, t2) -> t1.getPriority().compareTo(t2.getPriority()));
        taskArrayList.forEach(System.out::println);
    }
}

