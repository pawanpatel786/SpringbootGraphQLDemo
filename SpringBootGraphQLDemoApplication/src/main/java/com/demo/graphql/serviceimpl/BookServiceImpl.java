package com.demo.graphql.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.graphql.model.BookInfo;
import com.demo.graphql.repository.BookRepository;
import com.demo.graphql.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepo;

	@Override
	public BookInfo createBook(BookInfo b) {
		// TODO Auto-generated method stub
		return bookRepo.save(b);
	}

	@Override
	public List<BookInfo> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public BookInfo getBook(int id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).get();
	}

	@Override
	public BookInfo updateBook(int id,BookInfo book) {
		// TODO Auto-generated method stub
		BookInfo bookInfo = bookRepo.findById(id).get();
		bookInfo.setAuthor(book.getAuthor());
		bookInfo.setName(book.getName());
		bookInfo.setPrice(book.getPrice());
		bookInfo.setPublisher(book.getPublisher());
		return bookRepo.save(bookInfo);
	}

}
