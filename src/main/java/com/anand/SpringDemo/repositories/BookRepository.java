package com.anand.SpringDemo.repositories;

import com.anand.SpringDemo.demo.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
