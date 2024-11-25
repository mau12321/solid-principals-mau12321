package edu.ensign.cs460.solid.sr;

import java.util.ArrayList;
import java.util.List;

public final class SingleResponsibilityExample {
    private SingleResponsibilityExample() {
    }

    public static void main(final String[] args) {
        String expName = "John Doe";
        int expId = 1;
        List<String> expCourses = new ArrayList<String>() {
            {
                add("Math");
                add("Science");
                add("Art");
            }
        };

        Student actStudentJohn = new Student(expName, expId);
        actStudentJohn.setCourses(expCourses);

        Assignment mathAssignment = new Assignment(
                1,
                "OnePlusOne",
                "Math",
                "You must do your best to add 1+1",
                "1+1=2");

        Assignment scienceAssignment = new Assignment(
                2,
                "SpeedOfLight",
                "Science",
                "You must do your best to understand the speed of light",
                "e=mc^2");

        Assignment artAssignment = new Assignment(
                3,
                "Art for Art's Sake",
                "Art",
                "You must do your best to not evaluate art using normal criteria",
                "ars gratia artis");

        ArrayList<Assignment> expAssignments = new ArrayList<Assignment>() {
            {
                add(mathAssignment);
                add(scienceAssignment);
                add(artAssignment);
            }
        };

        actStudentJohn.setAssignments(expAssignments);

        System.out.println(mathAssignment.submitAssignment(actStudentJohn, "1+1=2"));
        System.out.println(scienceAssignment.submitAssignment(actStudentJohn, "e=mc^2"));
        System.out.println(artAssignment.submitAssignment(actStudentJohn, "Art?"));
    }
}
