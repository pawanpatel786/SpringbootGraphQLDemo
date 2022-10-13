package com.demo.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.graphql.model.BookInfo;
import com.demo.graphql.service.BookService;

//@RestController
public class BooksController {

	@Autowired
	BookService bookService;

	@GetMapping("/allBooks")
	public List<BookInfo> getAllBooks() {
		return bookService.getAllBooks();
	}
	
//	@GetMapping("/{ID}")
	public BookInfo getBook(@PathVariable int ID) {
		return bookService.getBook(ID);
	}
}
