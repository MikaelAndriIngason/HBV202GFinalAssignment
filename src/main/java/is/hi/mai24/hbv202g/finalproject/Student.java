package is.hi.mai24.hbv202g.finalproject;

public class Student extends User {
    // Variables
    private boolean feePaid;

    /**
     * Student constructor (creates a new student).
     * @param name student's name
     * @param password student's password
     * @param feePaid has the student paid the fee?
     */
    public Student(String name, String password, boolean feePaid) {
        super(name, password);
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
