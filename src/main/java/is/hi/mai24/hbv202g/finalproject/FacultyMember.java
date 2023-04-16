package is.hi.mai24.hbv202g.finalproject;

public class FacultyMember extends User {
    private String department;

    // Constructor
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
