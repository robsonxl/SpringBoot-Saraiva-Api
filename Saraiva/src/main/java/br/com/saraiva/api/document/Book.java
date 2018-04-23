package br.com.saraiva.api.document;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message="O SKU nao pode ser vazio/branco")
	private String sku;
	
	@NotBlank(message="O Nome não pode estar vazio/branco")
	private String name;
	
	@NotBlank(message="A Marca não pode estar vazio/branco")
	private String brand;
	
	@NotBlank(message="O Preço não pode estar vazio/branco")
	private double price;
	
	public double getPrice() {
		return price;
	}
	
	public Book() {}

	public void setPrice(double price) {
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

}
