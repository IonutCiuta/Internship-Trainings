package library;

import java.util.List;

/**
 * Created by iciuta on 7/7/2016.
 */
public class BookChecks {
    public static boolean checkDuplicate(Book book1, Book book2) {
        return book1.equals(book2);
    }

    public static Book findLongestBook(List<Book> bookList) {
        Book longestBook = bookList.get(0);

        for(Book b : bookList) {
            if(b.getPages() >= longestBook.getPages()) {
                longestBook = b;
            }
        }

        return longestBook;
    }
}
