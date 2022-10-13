package com.demo.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.graphql.model.BookInfo;
import com.demo.graphql.service.BookService;

@SpringBootApplication
public class SpringBootGraphQlDemoApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphQlDemoApplication.class, args);
	}

	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		BookInfo b1 = new BookInfo();
		b1.setAuthor("rd sharma-1");
		b1.setPrice(200);
		b1.setPublisher("NCERT-1");
		b1.setName("physics wala-1");

		BookInfo b2 = new BookInfo();
		b2.setAuthor("rd sharma-2");
		b2.setPrice(200);
		b2.setPublisher("NCERT-2");
		b2.setName("physics wala-2");

		BookInfo b3 = new BookInfo();
		b3.setAuthor("rd sharma-3");
		b3.setPrice(200);
		b3.setPublisher("NCERT-3");
		b3.setName("physics wala-3");

		bookService.createBook(b1);
		bookService.createBook(b2);
		bookService.createBook(b3);

	}

}
