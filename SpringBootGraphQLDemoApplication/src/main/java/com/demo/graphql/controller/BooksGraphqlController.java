package com.demo.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.demo.graphql.model.BookInfo;
import com.demo.graphql.service.BookService;

@Controller
public class BooksGraphqlController {

	@Autowired
	BookService bookService;

	@QueryMapping("allBooks")
	public List<BookInfo> getAllBooks() {
		return bookService.getAllBooks();
	}

	@QueryMapping
	public BookInfo getBook(@Argument Integer id) {
		System.out.println("================bookid=" + id);

		return bookService.getBook(Integer.parseInt("1"));
	}


//	@SchemaMapping(typeName = "Mutation", field = "addBookByParameter")
//	public String addBookByParameter(@Argument String author, @Argument String name, @Argument String publisher,
//			@Argument Double price) {
//		System.out.println("author+" + author);
//		return "success!!";
//	}

	@MutationMapping
	public String addBookByParameter(@Argument String author, @Argument String name, @Argument String publisher,
			@Argument Double price) {
		System.out.println("author+" + author + "," + name + " , " + publisher + " , " + price);
		return "success!!";
	}

//	@SchemaMapping(typeName = "Mutation", field = "addBookByObject")
//	public BookInfo addBookByObject(@Argument BookInput book) {
//		System.out.println("author+" + book.getAuthor() + "," + book.getName() + " , " + book.getPublisher() + " , "
//				+ book.getPrice());
//		BookInfo bookInfo = new BookInfo(book.getAuthor(), book.getName(), book.getPublisher(), book.getPrice());
//		return bookService.createBook(bookInfo);
//	}

	@MutationMapping
	public BookInfo addBookByObject(@Argument BookInput book) {
//		System.out.println("author+" + book.getAuthor() + "," + book.getName() + " , " + book.getPublisher() + " , "
//				+ book.getPrice());
		BookInfo bookInfo = new BookInfo(book.getAuthor(), book.getName(), book.getPublisher(), book.getPrice());
		return bookService.createBook(bookInfo);
	}

	@MutationMapping
	public BookInfo updateBook(@Argument Integer id, @Argument BookInput book) {
		System.out.println("id=" + id + " " + book.getAuthor() + "," + book.getName() + " , " + book.getPublisher()
				+ " , " + book.getPrice());
		BookInfo bookInfo = new BookInfo(book.getAuthor(), book.getName(), book.getPublisher(), book.getPrice());
		return bookService.updateBook(id, bookInfo);
	}

	class BookInput {

		String name;
		String author;
		String publisher;
		Double price;

		// for input object we must need to create the constructor with parameter. that
		// will be used by graphql internally to mapped the data
		public BookInput(String name, String author, String publisher, Double price) {
			this.name = name;
			this.author = author;
			this.publisher = publisher;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

	}
}
