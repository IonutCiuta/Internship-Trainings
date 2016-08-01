package com.endava.mvc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.endava.mvc.dto.BookDTO;
import com.endava.mvc.model.BookEntity;
import com.endava.mvc.repository.BookRepository;
import com.endava.mvc.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOG = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private Mapper mapper;

    @Override
    @Transactional(readOnly = true)
    public BookDTO getBookByID(Integer id) {
        LOG.info("Query db for book with id {}", id);
        BookEntity bookEntity = bookRepository.findOne(id);
        return bookEntity != null ? mapper.map(bookEntity, BookDTO.class) : null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookDTO> getAllBooks() {
        List<BookDTO> books = Collections.emptyList();
        List<BookEntity> bookEntities = bookRepository.findAll();
        if(bookEntities != null && !bookEntities.isEmpty()) {
            books = new ArrayList<BookDTO>();
            for(BookEntity bookEntity : bookEntities) {
                books.add(mapper.map(bookEntity, BookDTO.class));
            }
        }
        return books;
    }

    @Override
    @Transactional
    public BookDTO saveBook(BookDTO bookDTO) {
        BookEntity bookEntity = mapper.map(bookDTO, BookEntity.class);
        return mapper.map(bookRepository.save(bookEntity), BookDTO.class);
    }

    @Override
    @Transactional
    public void deleteBook(Integer id) {
        bookRepository.delete(id);
    }
}
