package com.anand.SpringDemo.Bootstrap;

import com.anand.SpringDemo.demo.Author;
import com.anand.SpringDemo.demo.Book;
import com.anand.SpringDemo.demo.repositories.AuthorRepository;
import com.anand.SpringDemo.demo.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){

        Author anand = new Author(1,"anand","tiwari");
        Book ddd = new Book(2,"Domain Driven Design", "1234", "Harper Collins");
        anand.getBooks().add(ddd);
        ddd.getAuthors().add(anand);

        authorRepository.save(anand);
        bookRepository.save(ddd);


        Author anand2 = new Author(1,"Stieg","Larsson");
        Book ddd2 = new Book(3,"Girl with the dragon tattoo", "1234", "Harper Collins");
        anand2.getBooks().add(ddd2);
        ddd2.getAuthors().add(anand2);

        authorRepository.save(anand2);
        bookRepository.save(ddd2);
    }
}
