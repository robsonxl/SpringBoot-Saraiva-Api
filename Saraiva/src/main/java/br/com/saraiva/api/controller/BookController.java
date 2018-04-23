package br.com.saraiva.api.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.saraiva.api.document.Book;
import br.com.saraiva.api.mapper.BookMapper;
import br.com.saraiva.api.service.BookService;

@RestController
@RequestMapping(path ="api/book")
public class BookController {
	
	static final String GET_PRODUCT_FROM_SARAIVA_API = "https://api.saraiva.com.br/sc/produto/pdp/";
	static final String GET_PRODUCT_FROM_SARAIVA_API_RESOURCE = "/0/0/1/";
	
	@Autowired
	BookService bookService;	
	
	
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return ResponseEntity.ok(this.bookService.createBook(book));
	}
	
	@GetMapping(path="/external/sku/{sku}")
	public ResponseEntity<Book> findExternalSkuk(@PathVariable(name="sku") String sku){
		 RestTemplate restTemplate = new RestTemplate();
		 BookMapper bookMapper = restTemplate.getForObject(GET_PRODUCT_FROM_SARAIVA_API.concat(sku).concat(GET_PRODUCT_FROM_SARAIVA_API_RESOURCE), BookMapper.class);
		 Book book;
		try {
			book = bookMapper.mapToBook();
			this.bookService.createBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@GetMapping()
	public ResponseEntity<List<Book>> listByPriceAndSKu( @RequestParam(value="price",required=false) Optional<Double> price , @RequestParam(value="limit",required=false )  Optional<String> limit){
			return ResponseEntity.ok(this.bookService.listBookLessThan(price,limit));	
	}
	
	@GetMapping(path="/{sku}") 	 		
	public ResponseEntity<Optional<Book>> findBySku(@PathVariable(name="sku") String sku){
		return ResponseEntity.ok(this.bookService.listBookBySku(sku));
	}
	
	@DeleteMapping(path="/{sku}") 	 		
	public ResponseEntity<String>deleteBook(@PathVariable(name="sku") String sku){
		this.bookService.deleteBook(sku);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
