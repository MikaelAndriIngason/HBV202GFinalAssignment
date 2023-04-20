package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FacultyMemberTest {

    private FacultyMember facultyMember;

    @Before
    public void setUp() {
        facultyMember = new FacultyMember("Mikael Andri Ingason", "321", "Computer Science");
    }

    @Test
    public void testGetName() {
        assertEquals("Mikael Andri Ingason", facultyMember.getName());
    }

    @Test
    public void testSetName() {
        facultyMember.setName("John Doe");
        assertEquals("John Doe", facultyMember.getName());
    }

    @Test
    public void testSetPassword() {
        facultyMember.setPassword("123");
        assertEquals("123", facultyMember.getPassword());
    }

    @Test
    public void testSetDepartment() {
        facultyMember.setDepartment("Biology");
        assertEquals("Biology", facultyMember.getDepartment());
    }
}

