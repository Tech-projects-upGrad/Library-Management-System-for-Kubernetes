package com.upgrad.bookmanagement.controller;

import com.upgrad.bookmanagement.dto.BookDTO;
import com.upgrad.bookmanagement.entity.Book;
import com.upgrad.bookmanagement.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/book_app/v1")
public class BookController {


    @Autowired
    private BookService bookService ;

    @Autowired
    ModelMapper modelMapper;

    /**
     * Method for requesting books
     */

    @GetMapping(value="/book/request/{bookId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity requestBook(@PathVariable(name="bookId") int bookId){

        //convert movieDTO to MovieEntity

        Book requestedBook = new Book(bookId);
        Book issuedBook = bookService.requestBook(requestedBook);


        if(issuedBook != null) {
            BookDTO issuedBookDTO = modelMapper.map(issuedBook, BookDTO.class);
            return new ResponseEntity(issuedBookDTO, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping(value="/book/return/{bookId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity returnBook(@PathVariable(name="bookId") int bookId) {

        //convert movieDTO to MovieEntity

        Book requestedBook = new Book(bookId);
        Book returnedBook = bookService.returnBook(requestedBook);


        if (returnedBook != null) {
            return new ResponseEntity(returnedBook, HttpStatus.OK);
        }
        return null;
    }
}
