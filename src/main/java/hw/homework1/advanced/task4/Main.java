package hw.homework1.advanced.task4;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Cook pasta", 3);
        Task task2 = new Task("Cook pizza", 1);
        Task task3 = new Task("Cook cookies", 4);
        Task task4 = new Task("Cook potato", 2);

        TaskManager taskManager = new TaskManager();
        taskManager.addTaskToArrayList(task1);
        taskManager.addTaskToArrayList(task2);
        taskManager.addTaskToArrayList(task3);
        taskManager.addTaskToArrayList(task4);

        taskManager.removeTaskFromArrayList(task4);

        taskManager.sortArrayList();
    }



}
