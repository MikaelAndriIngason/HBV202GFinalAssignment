package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("Mikael Andri Ingason", "321");
    }

    @Test
    public void testGetName() {
        assertEquals("Mikael Andri Ingason", user.getName());
    }

    @Test
    public void testSetName() {
        user.setName("John Doe");
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("123");
        assertEquals("123", user.getPassword());
    }
}
