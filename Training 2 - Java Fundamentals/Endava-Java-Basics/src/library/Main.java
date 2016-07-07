package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by iciuta on 7/7/2016.
 */
public class Main {
    private static final int INPUT_STOP = 0;
    private static final int INPUT_OK = 1;
    private static final int INPUT_WRONG = -1;
    private static final int INPUT_NOT_NUMBER = -2;
    private static final int INPUT_ZERO_PAGES = -3;

    private static Scanner scanner = new Scanner(System.in);
    private static List<Book> books = new ArrayList<>();
    private static String input;
    private static Book newBook;

    public static void main(String[] args) {

        while(true) {

            /*Check addition*/
            lNew:
            while(true) {
                System.out.println("New book?(yes/no)");
                input = scanner.nextLine();

                switch (checkNew(input)) {
                    case INPUT_STOP:
                        return;
                    case INPUT_OK:
                        newBook = new Book();
                        break;
                    case INPUT_WRONG:
                        continue lNew;
                }

                break;
            }

            lTitle:
            while(true) {
                System.out.println("Title: ");
                input = scanner.nextLine();

                switch (checkStringData(input)) {
                    case INPUT_OK:
                        newBook.setTitle(input);
                        break;
                    case INPUT_WRONG:
                        continue lTitle;
                }

                break;
            }

            lAuthor:
            while(true) {
                System.out.println("Author: ");
                input = scanner.nextLine();

                switch (checkStringData(input)) {
                    case INPUT_OK:
                        newBook.setAuthor(input);
                        break;
                    case INPUT_WRONG:
                        System.out.println("Please type something.");
                        continue lAuthor;
                }

                break;
            }

            lPublisher:
            while(true) {
                System.out.println("Publisher: ");
                input = scanner.nextLine();

                switch (checkStringData(input)) {
                    case INPUT_OK:
                        newBook.setPublisher(input);
                        break;
                    case INPUT_WRONG:
                        System.out.println("Please type something.");
                        continue lPublisher;
                }

                break;
            }

            lPages:
            while(true) {
                System.out.println("Pages: ");
                input = scanner.nextLine();
                int pages = checkNumericData(input);

                switch (pages) {
                    case  INPUT_WRONG:
                        System.out.println("Please type something.");
                        continue lPages;

                    case INPUT_NOT_NUMBER:
                        System.out.println("You must type in a number!");
                        continue lPages;

                    case INPUT_ZERO_PAGES:
                        System.out.println("You wish book had 0 pages. . .");
                        continue lPages;

                    default:
                        newBook.setPages(pages);
                }

                break;
            }

            books.add(newBook);
            System.out.println("Books:\n" + books.toString());
        }
    }

    /*basic check for new input*/
    private static int checkNew(String input) {
        if (input.equals("yes")) {
            return INPUT_OK;
        } else if (input.equals("no")) {
            return INPUT_STOP;
        } else {
            return INPUT_WRONG;
        }
    }

    /*basic check for input*/
    private static int checkStringData(String input) {
        if (input.equals("")) {
            return INPUT_WRONG;
        } else {
            return INPUT_OK;
        }
    }

    /*basic check for pages*/
    private static int checkNumericData(String input) {
        int result;

        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            result = INPUT_NOT_NUMBER;
        }

        if(result == 0) {
            result = INPUT_ZERO_PAGES;
        }

        return result;
    }
}
