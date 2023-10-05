package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
       Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
       assertEquals(testJob.getName(), "Product tester");
       assertEquals(testJob.getEmployer().toString(), "ACME");
       assertEquals(testJob.getLocation().toString(), "Desert");
       assertEquals(testJob.getPositionType().toString(), "Quality Control");
       assertEquals(testJob.getCoreCompetency().toString(), "Persistence");
       assertTrue(testJob.getName() instanceof String);
       assertTrue(testJob.getEmployer() instanceof Employer);
       assertTrue(testJob.getLocation() instanceof Location);
       assertTrue(testJob.getPositionType() instanceof PositionType);
       assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String msg = "The .equals method returns false when two job objects have identical field values EXCEPT for ID";
        Boolean expected = false;
        Boolean actual = testJob1.equals(testJob2);
        assertEquals(expected, actual, msg);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String msg = "When passed a Job object, it should return a string that contains a new line before and after the job information.";
        Job testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + testJob1.getId() + "\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n";
        String actual = testJob1.toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String msg = "The string for the job object should contain a label for each field, followed by the data stored in that field. Each field should be on its own line";
        Job testJob1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected = "\nID: " + testJob1.getId() + "\nName: Product Tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality Control\nCore Competency: Persistence\n";
        String actual = testJob1.toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        String msg = "The method should return Data not available after the label if a field is empty.";
        Job testJob1 = new Job("", new Employer(""), new Location(""), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String expected=  "\nID: " + testJob1.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Quality Control\nCore Competency: Persistence\n";
        String actual = testJob1.toString();
        assertEquals(expected, actual, msg);
    }

    @Test
    public void testToStringWithIdOnly(){
        String msg = "If a Job object ONLY contains data for the id field, the method should return an error message";
        Job testJob = new Job();
        String expected = "OOPS! This job does not seem to exist.";
        String actual = testJob.toString();
        assertEquals(expected, actual, msg);
    }

}
