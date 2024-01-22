package com.example.bookservice.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.example.bookservice.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    private DynamoDBMapper mapper ;

    public void saveBook( final Book book){
        mapper.save(book);
    }

    public Book getBookByBookId(final String bookId){
        Book book = mapper.load(Book.class, bookId);
        return book;
    }
    public void updateBook(final Book book){
        saveBook(book);
    }
    public void deleteBookByBookId(final String bookId){

        Book book = new Book();
        book.setBookId(bookId);
        mapper.delete(book);
    }

    public List<Book> getAllBooks(){
        List<Book>booklist = mapper.scan(Book.class , new DynamoDBScanExpression());
        return booklist;
    }



}
