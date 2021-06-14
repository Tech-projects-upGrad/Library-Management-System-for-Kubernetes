package com.upgrad.bookmanagement.service;

import com.upgrad.bookmanagement.entity.Book;
import com.upgrad.bookmanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book requestBook(Book book) {

        Optional<Book> requestedBook = bookRepository.findById(book.getBookId());
        if(requestedBook.isPresent() && requestedBook.get().getBookCount()>0){
            int bookCount = requestedBook.get().getBookCount();
            Book updatedBookEntity = requestedBook.get();
            updatedBookEntity.setBookCount(bookCount-1);
            bookRepository.save(updatedBookEntity);
            return requestedBook.get();
        }
        return null;
    }

    @Override
    public Book returnBook(Book book) {
        Optional<Book> returnRequestBook = bookRepository.findById(book.getBookId());
        if(returnRequestBook.isPresent()){
            int bookCount = returnRequestBook.get().getBookCount();
            Book updatedBookEntity = returnRequestBook.get();
            updatedBookEntity.setBookCount(bookCount+1);
            bookRepository.save(updatedBookEntity);
            return returnRequestBook.get();
        }
        return null;
    }
}
