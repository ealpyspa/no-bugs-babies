package hw.homework1.advanced.task4;

public class Task {
    private String description;
    private Integer priority;

    public Task(String description, Integer priority) {
        this.description = description;
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                '}';
    }
}
