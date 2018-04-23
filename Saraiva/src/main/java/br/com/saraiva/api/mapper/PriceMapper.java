package br.com.saraiva.api.mapper;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value="bestPrice")
public class PriceMapper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

 
 
}
