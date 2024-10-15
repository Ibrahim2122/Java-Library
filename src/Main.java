import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student[] students = createStudentList();
        ArrayList<NewBook> books = createBookList();
        boolean flag = true;

        System.out.println("Welcome to Library application!");

        while (flag) {
            System.out.println("   1. List all books.\n   2. List all checked out books\n   3. Add a new book to the library\n   4. Search a book by ISBN number\n   5. Search a book by name\n   6. Log in as a student\n   7. List top 3 most checked out books\n   8. List top 3 student with the highest check out numbers\n   0. End program");
            System.out.print("\n Please Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: listtAllBooks(books);
                break;
                case 2: listCheckedBooks(books);
                break;
                case 3: addNewBook(books);
            }
        }


    }

    public static void listtAllBooks(ArrayList<NewBook> books) {
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println();
    }

    public static void listCheckedBooks(ArrayList<NewBook> books) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCheckedCounter() != 0) {
                System.out.println(books.get(i) + ", is Checkd? " + books.get(i).getIsChecked());
            }
        }
        System.out.println();
    }

    public static void addNewBook(ArrayList<NewBook> books) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ISBN number: ");
        String isbn = scanner.nextLine();

        System.out.print("Enter the Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the Author name: ");
        String author = scanner.nextLine();

        books.add(new NewBook(isbn, title, author, "F"));
        System.out.println();
    }

    public static void serachByISBN(ArrayList<NewBook> books, String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                System.out.println(books.get(i));
                return;
            }
        }
        System.out.println("No book found with the ISBN: " + isbn);
    }

    public static void serachByName(ArrayList<NewBook> books, String name) {
        boolean isThere = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().contains(name)) {
                System.out.println(books.get(i));
                isThere = true;
            }
        }
        if (!isThere) {
            System.out.println("No book found with the name: " + name);
        }
    }

    public static void checkBooktoStudent(Student student, NewBook book) {
        student.setCheckedBooks(book);
        book.updateCheckedCounter();
    }

    public static boolean isStudent(Student [] students, Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                return true;
            }
        }
        return false;
    }

    public static void listStudents(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public static void listTop3Books(ArrayList<NewBook> books) {
        NewBook first = books.get(0), second = books.get(1), third = books.get(2);
        for (NewBook book : books) {
            if (book.getCheckedCounter() > first.getCheckedCounter()) {
                // Shift down the values
                third = second;
                second = first;
                first = book;
            } else if (book.getCheckedCounter() > second.getCheckedCounter()) {
                third = second;
                second = book;
            } else if (book.getCheckedCounter() > third.getCheckedCounter()) {
                third = book;
            }
        }

        System.out.println("Top 3 most checked books: " + first + ", " + second + ", " + third);
    }

    public static void listTop3Students(Student[] students) {
        Student first = students[0], second = students[1], third = students[2];
        for (Student student : students) {
            if (student.getCheckedBooks().length > first.getCheckedBooks().length) {
                third = second;
                second = first;
                first = student;
            } else if (student.getCheckedBooks().length > second.getCheckedBooks().length) {
                third = second;
                second = student;
            } else if (student.getCheckedBooks().length > third.getCheckedBooks().length) {
                third = student;
            }
        }
        System.out.println("Top 3 most checked books: " + first + ", " + second + ", " + third);
    }


    public static Student[] createStudentList() {
        Student[] students = new Student[15];

        String filePath = "C:\\Users\\myAdmin\\Desktop\\IdeaProjects\\Library\\src\\Students.txt";  // Specify your file path
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String [] student = line.split(" ");
                students[i] = new Student(Integer.valueOf(student[0]), student[1], student[2]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static ArrayList<NewBook> createBookList() {
        ArrayList<NewBook> books = new ArrayList<>();  // Use ArrayList instead of array

        String filePath = "C:\\Users\\myAdmin\\Desktop\\IdeaProjects\\Library\\src\\Books.txt";  // Specify your file path
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] book = line.split(",");
                books.add(new NewBook(book[0], book[1], book[2], book[3]));  // Add book to ArrayList
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}
