package edu.ensign.cs460.solid.sr;

import java.util.List;

public final class Student {
    private final String name;
    private final int id;
    private List<String> courses;
    private List<Assignment> assignments;

    public Student(final String name, final int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(final List<String> courses) {
        this.courses = courses;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(final List<Assignment> assignments) {
        this.assignments = assignments;
    }

    // Delegate the grading to Assignment
    public String submitAssignment(Assignment assignment, String assignmentText) {
        return assignment.submitAssignment(this, assignmentText);
    }
}
