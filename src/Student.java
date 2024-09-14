public class Student {
    private int id;
    private String firstName;
    private String lastName;
    public Book[] checkedBooks;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setCheckedBooks(Book checkedBook) {
        this.checkedBooks[this.checkedBooks.length - 1] = checkedBook;
        checkedBook.updateCheckedCounter();
    }

    @Override
    public String toString() {
        return "Student: id=" + id + ", First Name =" + firstName + ", Last Name =" + lastName + "]";
    }
}
