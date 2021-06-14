package com.upgrad.bookmanagement.service;

import com.upgrad.bookmanagement.entity.Book;

public interface BookService {
    public Book requestBook(Book book);
    public Book returnBook(Book book);
}
