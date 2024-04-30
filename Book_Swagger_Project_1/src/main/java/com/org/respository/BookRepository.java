package com.org.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.entity.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
