package javac CourseRegistrationSystem.java;
public class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int availableSlots;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.availableSlots = capacity;
        this.schedule = schedule;
    }

    // Getters and setters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getCapacity() { return capacity; }
    public int getAvailableSlots() { return availableSlots; }
    public String getSchedule() { return schedule; }

    public void setAvailableSlots(int availableSlots) { this.availableSlots = availableSlots; }

    @Override
    public String toString() {
        return code + ": " + title + " - " + description + " (Slots: " + availableSlots + "/" + capacity + ") " + schedule;
    }
}
