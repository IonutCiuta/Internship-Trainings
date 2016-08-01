package com.endava.mvc.service;

import java.util.List;

import com.endava.mvc.dto.BookDTO;

public interface BookService {

    BookDTO getBookByID(Integer id);

    List<BookDTO> getAllBooks();

    BookDTO saveBook(BookDTO bookDTO);

    void deleteBook(Integer id);
}
