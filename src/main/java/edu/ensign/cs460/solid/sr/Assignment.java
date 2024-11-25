package edu.ensign.cs460.solid.sr;

/**
 * Represents an assignment with grading logic.
 */
public final class Assignment {
    private final int assignmentId;
    private final String name; // Name of the assignment
    private final String courseName; // Course the assignment belongs to
    private final String description; // Description of the assignment
    private final String rubric; // The correct answer or grading rubric

    /**
     * Constructor for Assignment.
     *
     * @param assignmentId The unique ID of the assignment.
     * @param name         The name of the assignment.
     * @param courseName   The course to which the assignment belongs.
     * @param description  A brief description of the assignment.
     * @param rubric       The correct rubric text for grading.
     */
    public Assignment(final int assignmentId, final String name, final String courseName, 
                      final String description, final String rubric) {
        this.assignmentId = assignmentId;
        this.name = name;
        this.courseName = courseName;
        this.description = description;
        this.rubric = rubric;
    }

    /**
     * Gets the course name associated with the assignment.
     *
     * @return The course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Gets the name of the assignment.
     *
     * @return The name of the assignment.
     */
    public String getName() {
        return name;
    }

    /**
     * Submits an assignment for grading.
     *
     * @param student         The student submitting the assignment.
     * @param assignmentText  The text submitted by the student.
     * @return A string indicating the grade or if the course is not configured.
     */
    public String submitAssignment(final Student student, final String assignmentText) {
        // Ensure the student is enrolled in the course
        if (!student.getCourses().contains(courseName)) {
            return "Grade: course not configured";
        }
        // Compare the submission to the rubric
        String grade = assignmentText.equals(rubric) ? "A" : "F";
        return student.getName() + " Receives the following assessment - Course: " + courseName +
                ", Assignment: " + name + ", Grade: " + grade;
    }
}
