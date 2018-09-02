package com.anand.SpringDemo.repositories;

import com.anand.SpringDemo.demo.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
