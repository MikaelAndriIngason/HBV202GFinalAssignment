package is.hi.mai24.hbv202g.finalproject;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Library {
    // Variables
    private static LibrarySystem librarySystem = new LibrarySystem();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Main method.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        try {
            createDummyData();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int menuChoice = 0;
        // While loop to keep the program running if the user doesn't exit
        while (menuChoice != 2) {
            System.out.println("Welcome to the library!");
            System.out.println("=================================");
            System.out.println("1. Sign in");
            System.out.println("2. Exit");
            menuChoice = scanner.nextInt();
            scanner.nextLine();

            // If the user chooses to sign in
            if (menuChoice == 1) {
                System.out.println("Username:");
                String username = scanner.nextLine();
                System.out.println("Password:");
                String password = scanner.nextLine();

                // If an admin is logging in
                if (username.equals("admin") && password.equals("123")) {
                    logInAsAdmin();
                } else {
                    try {
                        User user = librarySystem.findUserByName(username);
                        if (user.getPassword().equals(password)) {
                            // If a student is logging in
                            if (user instanceof Student) {
                                logInAsStudent(user);
                            }
                            // If a faculty member is logging in
                            else if (user instanceof FacultyMember) {
                                logInAsFacultyMember(user);
                            }
                        } else if (user.getName().equals(username)) {
                            System.out.println("Incorrect password!");
                        } else {
                            System.out.println("User does not exist!");
                        }
                    } catch (UserOrBookDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            // If the user chooses to exit
            else if (menuChoice == 2) {
                System.out.println("Goodbye!");
            }
        }
    }

    /**
     * Creates a dummy data for the library system.
     * @throws EmptyAuthorListException
     */
    private static void createDummyData() throws EmptyAuthorListException {
        librarySystem.addStudentUser("Timmy", "123", false);
        librarySystem.addStudentUser("Jessica", "321", true);
        librarySystem.addStudentUser("Bob", "111", true);

        librarySystem.addFacultyMember("John", "999", "Computer Science");
        librarySystem.addFacultyMember("Mary", "222", "Astronomy");
        librarySystem.addFacultyMember("Jane", "333", "Physics");

        librarySystem.addBookWithTitleAndAuthorlist("The Lord of the Rings", Arrays.asList(new Author("J.R.R. Tolkien")));
        librarySystem.addBookWithTitleAndAuthorlist("Harry Potter", Arrays.asList(new Author("J.K. Rowling")));
        librarySystem.addBookWithTitleAndAuthorlist("The Hobbit", Arrays.asList(new Author("J.R.R. Tolkien")));
        librarySystem.addBookWithTitleAndAuthorlist("Game of Thrones", Arrays.asList(new Author("George R. R. Martin")));
    }

    /**
     * Logs in as an administrator. Can add books and users.
     */
    private static void logInAsAdmin() {
        int choice = 0;

        System.out.println("Logged in as ADMINISTRATOR.");
        System.out.println("=================================");

        // While admin has not chosen to log out
        while (choice != 3) {
            System.out.println("1. Add a book");
            System.out.println("2. Add a user");
            System.out.println("3. Log out");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // If admin wants to add a book
                case 1:
                    System.out.println("Enter name of book:");
                    String title = scanner.nextLine();
                    System.out.println("Enter author name(s):");
                    String author = scanner.nextLine();

                    // Add the book to the library
                    try {
                        librarySystem.addBookWithTitleAndAuthorlist(title, Arrays.asList(new Author(author)));
                        System.out.println("Book added.");
                    } catch (EmptyAuthorListException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // If admin wants to add a user
                case 2:
                    System.out.println("Enter name of user:");
                    String name = scanner.nextLine();
                    System.out.println("Enter password:");
                    String password1 = scanner.nextLine();
                    System.out.println("Enter the type of user (student, faculty):");
                    String type = scanner.next();

                    // If the user is a student
                    if (type.equals("student")) {
                        System.out.println("Has the student paid? (true, false):");
                        boolean feePaid = scanner.nextBoolean();
                        librarySystem.addStudentUser(name, password1, feePaid);
                        System.out.println("User added.");
                    }
                    // If the user is a faculty member
                    else if (type.equals("faculty")) {
                        System.out.println("Enter the department:");
                        String department = scanner.next();
                        librarySystem.addFacultyMember(name, password1, department);
                        System.out.println("User added.");
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                // If admin wants to log out
                case 3:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("=================================");
        }
    }

    /**
     * Logs in as a student. Can borrow books and return them.
     * @param user
     */
    private static void logInAsStudent(User user) {
        int choice = 0;

        System.out.println("Logged in as " + user.getName() + " (STUDENT).");
        System.out.println("=================================");

        // While student has not chosen to log out
        while (choice != 3) {
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Log out");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // If student wants to borrow a book
                case 1:
                    System.out.println("Enter name of book:");
                    String title = scanner.nextLine();
                    // Borrows the book
                    try {
                        librarySystem.borrowBook(user, librarySystem.findBookByTitle(title));
                        System.out.println("Book borrowed.");
                    } catch (UserOrBookDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // If student wants to return a book
                case 2:
                    System.out.println("Enter name of book:");
                    String title1 = scanner.nextLine();
                    try {
                        librarySystem.returnBook(user, librarySystem.findBookByTitle(title1));
                        System.out.println("Book returned.");
                    } catch (UserOrBookDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // If student wants to log out
                case 3:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("=================================");
        }
    }

    /**
     * Logs in as a faculty member. Can extend lending period of books.
     * @param user
     */
    private static void logInAsFacultyMember(User user) {
        int choice = 0;

        System.out.println("Logged in as " + user.getName() + " (FACULTY).");
        System.out.println("=================================");

        // While faculty member has not chosen to log out
        while (choice != 2) {
            System.out.println("1. Extend lending");
            System.out.println("2. Log out");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                // If faculty member wants to extend lending
                case 1:
                    System.out.println("Enter name of book:");
                    String title = scanner.nextLine();
                    System.out.println("Number of days to extend by:");
                    int days = scanner.nextInt();
                    // Extend the lending period
                    try {
                        librarySystem.extendLending(librarySystem.findBookByTitle(title), LocalDate.now().plusDays(days));
                        System.out.println("Lending extended.");
                    } catch (UserOrBookDoesNotExistException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // If faculty member wants to log out
                case 2:
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println("=================================");
        }
    }
}
