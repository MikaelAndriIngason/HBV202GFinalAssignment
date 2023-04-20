package is.hi.mai24.hbv202g.finalproject;

public class User {
    private String name;
    private String password;

    // Constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
