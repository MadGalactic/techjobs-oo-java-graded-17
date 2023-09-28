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
        assertFalse(testJob1.equals(testJob2));
    }
}
