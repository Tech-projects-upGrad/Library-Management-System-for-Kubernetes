package com.upgrad.library.controller;

import com.upgrad.library.dto.BookDTO;
import com.upgrad.library.entity.Book;
import com.upgrad.library.service.LibraryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/library_app/v1")
public class LibraryController {


        @Autowired
        private LibraryService libraryService ;

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
            Book issuedBook = libraryService.requestBook(requestedBook);


            if(issuedBook != null) {
                BookDTO issuedBookDTO = modelMapper.map(issuedBook, BookDTO.class);
                return new ResponseEntity(issuedBookDTO, HttpStatus.OK);
            }
            return new ResponseEntity("Book is unavailable !!", HttpStatus.OK) ;
        }

    @GetMapping(value="/book/return/{bookId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity returnBook(@PathVariable(name="bookId") int bookId){

        //convert movieDTO to MovieEntity

        Book requestedBook = new Book(bookId);
        Book returnedBook = libraryService.returnBook(requestedBook);


        if(returnedBook != null) {
            return new ResponseEntity("Book returned Successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Invalid Book Id.", HttpStatus.OK) ;
    }
}
