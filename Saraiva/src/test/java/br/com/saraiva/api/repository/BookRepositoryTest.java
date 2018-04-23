package br.com.saraiva.api.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.saraiva.api.document.Book;
import br.com.saraiva.api.repository.BookRepository;
import br.com.saraiva.api.service.BookService;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
	    "classpath:src/test/resources/test-context.xml"})
 
public class BookRepositoryTest {
 
	@Autowired
	private BookService sevice;
	
	@Test
	public void repositorySaveBook() {
		
		Book book = new Book();
		book.setName("name test");
		book.setBrand("brand test");
		book.setPrice(10.50d);
		
		Book bookResult = sevice.createBook(book);
        assertEquals(bookResult.getName(), "name test");
        assertEquals(bookResult.getBrand(), "brand test");
	}
	

}
