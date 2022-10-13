package com.demo.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.graphql.model.BookInfo;

public interface BookRepository extends JpaRepository<BookInfo, Integer> {

}
