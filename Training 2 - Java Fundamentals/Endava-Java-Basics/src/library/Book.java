package library;

/**
 * Created by iciuta on 7/7/2016.
 */
public class Book {
    private String title, author, publisher;
    private Integer pages;

    public Book() {
    }

    public Book(String title, String author, String publisher, Integer pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "\nTitle: " + title.toUpperCase() + '\n' + "Author: " + author + '\n' +
               "Publisher: " + publisher + '\n' + "Pages: " + pages + "\n";
    }

    /*default smartass IntelliJ equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        if (!publisher.equals(book.publisher)) return false;
        return pages.equals(book.pages);

    }

    /*default IntelliJ hashcode*/
    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publisher.hashCode();
        result = 31 * result + pages.hashCode();
        return result;
    }
}
