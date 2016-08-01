package com.endava.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.endava.mvc.dto.BookDTO;
import com.endava.mvc.service.BookService;
import com.endava.mvc.validator.BookRequestValidator;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRequestValidator bookValidator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(bookValidator);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBook(@PathVariable Integer id) {
        return bookService.getBookByID(id);
    }

    @RequestMapping(value = "/getBook", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BookDTO getBookV2(@RequestParam("id") Integer id) {
        return bookService.getBookByID(id);
    }

	/**
     * Am uitat sa va spun in prezentare ca un alt mod de a intoarce raspunsul e printr-un {@link ResponseEntity}
     * Am adaugat aici un exemplu. Acelasi lucru se poate face si pentru celelalte metode
     *
     * @param id the book id
     * @return the value found in the database for the id received as parameter, null otherwise
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<BookDTO> getBookV3(@PathVariable Integer id) {
        return new ResponseEntity<BookDTO>(bookService.getBookByID(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/listBooks", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO saveBook(@RequestBody @Valid BookDTO book) {
        return bookService.saveBook(book);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }

}
