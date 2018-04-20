package com.rekik.libraryapril;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    //private LocalDate yearOfPublication;
    private long yearPub;
    private String isbn;
    private boolean isAvailable;

    public Book() {
        isAvailable = true;
        yearPub = 2018;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getYearPub() {
        return yearPub;
    }

    public void setYearPub(long yearPub) {
        this.yearPub = yearPub;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}