package is.hi.mai24.hbv202g.finalproject;

public class FacultyMember extends User {
    // Variables
    private String department;

    /**
     * FacultyMember constructor (creates a new faculty member).
     * @param name faculty member's name
     * @param password faculty member's password
     * @param department faculty member's department
     */
    public FacultyMember(String name, String password, String department) {
        super(name, password);
        this.department = department;
    }

    // Getters and setters

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
