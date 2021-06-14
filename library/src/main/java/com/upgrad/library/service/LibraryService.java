package com.upgrad.library.service;

import com.upgrad.library.entity.Book;

public interface LibraryService {
    public Book requestBook(Book book);
    public Book returnBook(Book book);

}
