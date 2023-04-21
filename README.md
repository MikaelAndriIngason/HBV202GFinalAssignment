# HBV202G - Final Assignment
Mikael Andri Ingason - mai24@hi.is

---

### The project
Library system, continued from assignment 8.
In this assignment we use everything the weekly assignments covered (Maven, JUnit, Git, UML design, refactoring, JAR and documentation).

Here we have an interface where the user can log into the library, either as an administrator, student or faculty member. Each has their own purpose and functionality.
- Students can borrow and return books.
- Faculty members can extend the lending time of students books.
- Administrator can add new books and users (both students and faculty members).

(To sign in as admin use the following: username: admin, password: 123)

### Building and running
Maven:

- `mvn compile` compiles all implementation classes.
- `mvn test` runs all test cases.
- `mvn exec:java` executes the main method (Library).

Create JAR file:

- `mvn package` creates the JAR file, located in the target directory.  


Run the JAR file in terminal/cmd in project directory:
```bash
java -cp target/finalproject-1.0-SNAPSHOT.jar is.hi.mai24.hbv202g.finalproject.Library
```

### License
[MIT Licence](LICENSE)

### UML class diagram
[UML class diagram](src/site/markdown/documentation.md)