package com.demo.graphql.service;

import java.util.List;

import com.demo.graphql.model.BookInfo;

public interface BookService {

	public BookInfo createBook(BookInfo b);

	public List<BookInfo> getAllBooks();

	public BookInfo getBook(int id);
	
	public BookInfo updateBook(int id,BookInfo book);
	
	

}
