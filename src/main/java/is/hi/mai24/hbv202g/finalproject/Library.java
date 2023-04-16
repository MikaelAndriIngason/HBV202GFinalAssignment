package is.hi.mai24.hbv202g.finalproject;

import java.util.Arrays;
import java.util.Scanner;

public class Library {

    private LibrarySystem librarySystem;

    public static void main(String[] args) {
        LibrarySystem librarySystem = new LibrarySystem();

        // Text interface
        System.out.println("Welcome to the library system!");
        System.out.println("Please log in:");
        System.out.println("1. Administrator");
        System.out.println("2. Student");
        System.out.println("3. Faculty member");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        //scanner
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        //administrator
        if (choice == 1) {
            System.out.println("Logged in: Administrator");
            //librarySystem.addBookWithTitleAndAuthorlist("The Lord of the Rings", Arrays.asList(new Author("J.R.R. Tolkien"), new Author("George R.R. Martin")));
        }
    }
}
