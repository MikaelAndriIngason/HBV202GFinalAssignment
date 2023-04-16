package is.hi.mai24.hbv202g.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Library {

    private static LibrarySystem librarySystem = new LibrarySystem();

    public static void main(String[] args) throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        createDummyData();

        Scanner scanner = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice != 2) {
            System.out.println("Welcome to the library!");
            System.out.println("1. Sign in");
            System.out.println("2. Exit");
            menuChoice = scanner.nextInt();
            scanner.nextLine();
            if (menuChoice == 1) {
                System.out.println("Username:");
                String username = scanner.nextLine();
                System.out.println("Password:");
                String password = scanner.nextLine();

                if (username.equals("admin") && password.equals("123")) {
                    int choice = 0;

                    System.out.println("Logged in as ADMINISTRATOR.");

                    while (choice != 3) {
                        System.out.println("1. Add a book");
                        System.out.println("2. Add a user");
                        System.out.println("3. Log out");
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                System.out.println("Enter name of book:");
                                String title = scanner.nextLine();
                                System.out.println("Enter author name(s):");
                                String author = scanner.nextLine();
                                librarySystem.addBookWithTitleAndAuthorlist(title, Arrays.asList(new Author(author)));
                                System.out.println("Book added.");
                                break;
                            case 2:
                                System.out.println("Enter name of user:");
                                String name = scanner.nextLine();
                                System.out.println("Enter password:");
                                String password1 = scanner.nextLine();
                                System.out.println("Enter the type of user (student, faculty):");
                                String type = scanner.next();
                                if (type.equals("student")) {
                                    System.out.println("Has the student paid? (true, false):");
                                    boolean feePaid = scanner.nextBoolean();
                                    librarySystem.addStudentUser(name, password1, feePaid);
                                } else if (type.equals("faculty")) {
                                    System.out.println("Enter the department:");
                                    String department = scanner.next();
                                    librarySystem.addFacultyMember(name, password1, department);
                                }
                                System.out.println("User added.");
                                break;
                            case 3:
                                System.out.println("Logged out.");
                                break;
                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                        System.out.println("=================================");
                    }
                } else {
                    User user = librarySystem.findUserByName(username);
                    if (user instanceof Student) {
                        int choice = 0;

                        System.out.println("Logged in as STUDENT.");

                        while (choice != 3) {
                            System.out.println("1. Borrow a book");
                            System.out.println("2. Return a book");
                            System.out.println("3. Log out");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1:
                                    System.out.println("Enter name of book:");
                                    String title = scanner.nextLine();
                                    librarySystem.borrowBook(user, librarySystem.findBookByTitle(title));
                                    System.out.println("Book borrowed.");
                                    break;
                                case 2:
                                    System.out.println("Enter name of book:");
                                    String title1 = scanner.nextLine();
                                    librarySystem.returnBook(user, librarySystem.findBookByTitle(title1));
                                    System.out.println("Book returned.");
                                    break;
                                case 3:
                                    System.out.println("Logged out.");
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            System.out.println("=================================");
                        }
                    } else if (user instanceof FacultyMember) {
                        int choice = 0;

                        System.out.println("Logged in as FACULTY.");

                        while (choice != 2) {
                            System.out.println("1. Extend lending");
                            System.out.println("2. Log out");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice) {
                                case 1:
                                    System.out.println("Enter name of book:");
                                    String title = scanner.nextLine();
                                    System.out.println("Number of days to extend by:");
                                    int days = scanner.nextInt();
                                    librarySystem.extendLending(librarySystem.findBookByTitle(title), LocalDate.now().plusDays(days));
                                    System.out.println("Lending extended.");
                                    break;
                                case 2:
                                    System.out.println("Logged out.");
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            System.out.println("=================================");
                        }
                    } else {
                        System.out.println("User does not exist.");
                    }
                }
            } else if (menuChoice == 2) {
                System.out.println("Goodbye!");
            }
        }
    }

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
}
