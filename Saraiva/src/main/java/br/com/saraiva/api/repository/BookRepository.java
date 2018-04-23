package br.com.saraiva.api.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.saraiva.api.document.Book;

public interface BookRepository extends MongoRepository<Book, String> {
	
	Optional<Book> findByPriceLessThanEqual(BigDecimal prive);

}
