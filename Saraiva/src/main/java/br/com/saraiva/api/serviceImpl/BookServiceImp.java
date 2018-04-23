package br.com.saraiva.api.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.saraiva.api.document.Book;
import br.com.saraiva.api.repository.BookRepository;
import br.com.saraiva.api.service.BookService;

@Service
public class BookServiceImp implements BookService {
	
	@Autowired
	BookRepository bookRepo;
	@Autowired private MongoOperations operations;

	@Override
	public void deleteBook(String sku) {
		this.bookRepo.deleteById(sku);
	}

	@Override
	public Optional<Book> listBookBySku(String Sku) {
		return this.bookRepo.findById(Sku);
	}

	@Override
	public Book createBook(Book book) {
		return this.bookRepo.save(book);
	}

	@Override
	public List<Book> listBookLessThan(Optional<Double> price, Optional<String> limit) {
		List<Book> booksResult = new ArrayList<Book>();
		Query query = new Query();
		if(!price.isPresent() && !limit.isPresent()) {
			booksResult.addAll(this.bookRepo.findAll());
			return booksResult;
		}
		if(price.isPresent() && limit.isPresent()) {
			 query.addCriteria(Criteria.where("price").lte(price.get())).limit(Integer.parseInt(limit.get()));
			 booksResult.addAll(operations.find(query,Book.class));
		}else if(price.isPresent()) {
			 query.addCriteria(Criteria.where("price").lte(price.get()));
			 booksResult.addAll(operations.find(query,Book.class));
		}else {
			 query.limit(Integer.parseInt(limit.get()));
			 booksResult.addAll(operations.find(query,Book.class));
		}
		return booksResult;
	}
}
