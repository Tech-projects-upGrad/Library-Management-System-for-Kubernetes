package com.upgrad.library.service;

import com.upgrad.library.entity.Book;
import com.upgrad.library.feign.BookServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private RestTemplate restTemplate;

    @Value("${bookManagement.url}")
    private String bookManagementUrl;

    @Autowired
    private BookServiceClient bookServiceClient;

    @Override
    public Book requestBook(Book book) {


        Map<String,String> bookUriMap = new HashMap<>();
        bookUriMap.put("bookId",String.valueOf(book.getBookId()));
        Book receivedBook = restTemplate.getForObject(bookManagementUrl,Book.class,bookUriMap);

        return receivedBook;
    }

    @Override
    public Book returnBook(Book book) {
        Book returnedBook = bookServiceClient.returnBook(book.getBookId());
        return returnedBook;
    }
}
