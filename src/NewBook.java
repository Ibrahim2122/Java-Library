public class NewBook {
    private String isbn;
    private String title;
    private String author;
    private String isChecked;
    private int checkedCounter;

    public NewBook(String isbn, String title, String author, String isChecked) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isChecked = isChecked;

        if (isChecked.equals("T")) {
            checkedCounter++;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public int getCheckedCounter() {
        return checkedCounter;
    }

    public void updateCheckedCounter() {
        checkedCounter++;
    }

    @Override
    public String toString() {
        return title + ", Wriiten by:  " + author + "\tNumber of people checked the book: " + checkedCounter;
    }
}
