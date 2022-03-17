package su.ibn.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import su.ibn.springdemo.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
