public class FacultyMember extends User {
    private String department;

    // Constructor
    public FacultyMember(String name, String department) {
        super(name);
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
