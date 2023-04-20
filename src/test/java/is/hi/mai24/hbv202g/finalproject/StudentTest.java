package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {

    private Student student;

    @Before
    public void setUp() {
        student = new Student("Mikael Andri Ingason", "321", true);
    }

    @Test
    public void testGetName() {
        assertEquals("Mikael Andri Ingason", student.getName());
    }

    @Test
    public void testSetName() {
        student.setName("John Doe");
        assertEquals("John Doe", student.getName());
    }

    @Test
    public void testSetPassword() {
        student.setPassword("123");
        assertEquals("123", student.getPassword());
    }

    @Test
    public void testIsFeePaid() {
        assertEquals(true, student.isFeePaid());
    }

    @Test
    public void testSetFeePaid() {
        student.setFeePaid(false);
        assertEquals(false, student.isFeePaid());
    }
}
