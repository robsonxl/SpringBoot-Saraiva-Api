package br.com.saraiva.api.service;

import java.util.List;
import java.util.Optional;

import br.com.saraiva.api.document.Book;

public interface BookService {
	
	Book createBook(Book book);
	void deleteBook(String sku);
	Optional<Book> listBookBySku(String Sku);
	List<Book> listBookLessThan(Optional<Double> price, Optional<String> limit);
	
}
