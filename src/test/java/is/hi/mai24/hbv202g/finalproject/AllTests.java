package is.hi.mai24.hbv202g.finalproject;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AuthorTest.class,
    BookTest.class,
    FacultyMemberTest.class,
    LendingTest.class,
    LibrarySystemTest.class,
    StudentTest.class,
    UserTest.class
})
public class AllTests {
}
