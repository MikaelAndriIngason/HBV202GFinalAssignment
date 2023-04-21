package is.hi.mai24.hbv202g.finalproject;

public class User {
    // Variables
    private String name;
    private String password;

    /**
     * User constructor (creates a new user).
     * @param name user's name
     * @param password user's password
     */
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
