package com.upgrad.bookmanagement.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId ;

    @Column( length=50, nullable = true , unique = true)
    private String bookName ;

    @Column(length = 500, nullable = true)
    private String bookDescription ;

    @Column(name = "book_count")
    private int bookCount ;

    public int getBookId() {
        return bookId;
    }

    public Book() {
    }

    public Book(int bookId, String bookName, String bookDescription, int bookCount) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookCount = bookCount;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Book(int bookId) {
        this.bookId = bookId;
    }
}
