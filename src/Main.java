import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student[] students = createStudentList();
        Book[] books = createBookList();


    }

    public static void listtAllBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    public static void listCheckedBooks(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getCheckedCounter() != 0) {
                System.out.println(books[i] + ": " + books[i].getIsChecked());
            }
        }
    }

    public static void addNewBook(Book[] books, Book book) {
        books[books.length - 1] = book;
    }

    public static void serachByISBN(Book[] books, String isbn) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                System.out.println(books[i]);
                return;
            }
        }
        System.out.println("No book found with the ISBN: " + isbn);
    }

    public static void serachByName(Book[] books, String name) {
        boolean isThere = false;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().contains(name)) {
                System.out.println(books[i]);
                isThere = true;
            }
        }
        if (!isThere) {
            System.out.println("No book found with the name: " + name);
        }
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

    public static Book[] createBookList() {
        Book[] books = new Book[15];

        String filePath = "C:\\Users\\myAdmin\\Desktop\\IdeaProjects\\Library\\src\\Books.txt";  // Specify your file path
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String [] book = line.split(",");
                books[i] = new Book(book[0], book[1], book[2], book[3]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}