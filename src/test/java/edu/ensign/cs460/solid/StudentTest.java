package edu.ensign.cs460.solid;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.sr.Assignment;
import edu.ensign.cs460.solid.sr.Student;

import java.util.ArrayList;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class StudentTest 
{
    private String expName;
    private int expId;
    private List<String> expCourses;
    private Student actStudentJohn;

    @BeforeEach
    void init() {
        expName = "John Doe";
        expId = 1;
        this.expCourses = new ArrayList<String>(){
            {
                add("Math");
                add("Science");
                add("Art");
            }
        };
        actStudentJohn = new Student(this.expName, this.expId);
        actStudentJohn.setCourses(this.expCourses);
    }

    @Test
    public void submitAssignment_happyPath_shouldReturnNameCourseAssignmentGrade() {
        // Arrange
        this.setupAssignments();
    
        // Act
        // Submit first math assignment
        Assignment actMathAssignment = this.actStudentJohn.getAssignments().stream()
                .filter(a -> a.getCourseName().equals("Math")).findFirst().get();
        String actMathAssessment = actMathAssignment.submitAssignment(this.actStudentJohn, "1+1=2");
    
        // Assert
        assertTrue(actMathAssessment.contains(this.expName));
        assertTrue(actMathAssessment.contains(this.expCourses.get(0))); // Math course
        assertTrue(actMathAssessment.contains(actMathAssignment.getName())); // Assignment name
        assertTrue(actMathAssessment.contains("A")); // Grade A
    }

    @Test
    public void submitAssignment_badCourse_shouldReturnCourseNotConfig() {
        // arrange
        Assignment weldingAssignment = new Assignment(
            1,
            "MeltMetal",
            "Welding",
            "You must do you best to melt metal",
            "iron melted"
        );

        List<Assignment> weldingAssignmentList = new ArrayList<Assignment>(){
            {
                add(weldingAssignment);
            }
        };

        this.actStudentJohn.setAssignments(weldingAssignmentList);

        // act
        String actBadAssessment = this.actStudentJohn.submitAssignment(this.actStudentJohn.getAssignments().stream()
            .filter(a -> a.getCourseName().equals(weldingAssignment.getCourseName())).findFirst().get(), 
            "iron melted");

        // assert
        assertTrue(actBadAssessment.contains("course not configured"));
    }

    private void setupAssignments() {
        // arrange
        Assignment mathAssignment = new Assignment(
            1,
            "OnePlusOne",
            "Math",
            "You must do you best to add 1+1",
            "1+1=2"
        );

        Assignment scienceAssignment = new Assignment(
            2,
            "SpeedOfLight",
            "Science",
            "You must do you best to understand the speed of light",
            "e=mc^2"
        );

        Assignment artAssignment = new Assignment(
            2,
            "Art for Art's Sake",
            "Art",
            "You must do you best to not evaluate art using normal criteria",
            "ars gratia artis"
        );

        ArrayList<Assignment> expAssignments = new ArrayList<Assignment>(){
            {
                add(mathAssignment);
                add(scienceAssignment);
                add(artAssignment);
            }
        };

        this.actStudentJohn.setAssignments(expAssignments);
    }

}   

