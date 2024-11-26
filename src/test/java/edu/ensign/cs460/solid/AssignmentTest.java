package edu.ensign.cs460.solid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ensign.cs460.solid.sr.Assignment;
import edu.ensign.cs460.solid.sr.Student;

import java.util.ArrayList;

public class AssignmentTest {
    private ArrayList<Assignment> expAssignments;
    private Student student;

    @BeforeEach
    private void init() {
        this.setupAssignments();
        this.setupStudent();
    }

    @Test
    public void submitAssignment_happyPath_shouldReturnGradeA(){
        // arrange

        // act
        String actGrade = this.expAssignments.get(0).submitAssignment(this.student, "1+1=2");

        // assert
        assert actGrade.equals("A");
    }


    @Test
    public void submitAssignment_badAssignmentText_shouldReturnGradeF() {
        // arrange
        this.setupStudent();

        // act
        // submit first math assignment
        String actGrade = this.expAssignments.get(0).submitAssignment(this.student,"1+1=3");

        // assert
        assert actGrade.equals("F");
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

        this.expAssignments = new ArrayList<Assignment>(){
            {
                add(mathAssignment);
                add(scienceAssignment);
                add(artAssignment);
            }
        };
    }

    private void setupStudent() {
        this.student = new Student(
            "John Doe", 
            1);
        this.student.setCourses(
            new ArrayList<String>(){
            {
                add("Math");
                add("Science");
                add("Art");
            }});    
    }

}
