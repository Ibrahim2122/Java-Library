public class Student {
    private int id;
    private String firstName;
    private String lastName;
    public NewBook[] checkedBooks;

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        checkedBooks = new NewBook[10];

    }

    public void setCheckedBooks(NewBook checkedBook) {
        this.checkedBooks[this.checkedBooks.length - 1] = checkedBook;
        checkedBook.updateCheckedCounter();
    }

    public NewBook[] getCheckedBooks() {
        return checkedBooks;
    }

    @Override
    public String toString() {
        return "Student: id=" + id + ", First Name =" + firstName + ", Last Name =" + lastName + "]";
    }
}
