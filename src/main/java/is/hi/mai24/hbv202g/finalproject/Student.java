package is.hi.mai24.hbv202g.finalproject;

public class Student extends User {
    private boolean feePaid;

    // Constructor
    public Student(String name, boolean feePaid) {
        super(name);
        this.feePaid = feePaid;
    }

    // Getters and setters

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }
}
