package br.com.saraiva.api.mapper;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.saraiva.api.document.Book;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookMapper implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("sku")
	private String sku;
	@JsonProperty("name")
	private String name;
	private PriceMapper price;
	@JsonProperty("brand")
	private String brand;
	
	public PriceMapper getPrice() {
		return price;
	}
	public void setPrice(PriceMapper price) {
		this.price = price;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Book mapToBook() throws ParseException {
		Book book = new Book();
		book.setSku(this.getSku());
		book.setName(this.getName());
		book.setBrand(this.getBrand());
		book.setPrice(Double.parseDouble(this.price.getValue().replace(",",".")));
		return book;
	}
	
	
	
}
