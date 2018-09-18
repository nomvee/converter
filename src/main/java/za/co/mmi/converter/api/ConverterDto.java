package za.co.mmi.converter.api;

import java.io.Serializable;


public class ConverterDto implements Serializable{

	private String convertFrom;
	
	private String convertTo;
	
	private double value;

	private double results;

	public String getConvertFrom() {
		return convertFrom;
	}

	public void setConvertFrom(String convertFrom) {
		this.convertFrom = convertFrom;
	}

	public String getConvertTo() {
		return convertTo;
	}

	public void setConvertTo(String convertTo) {
		this.convertTo = convertTo;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getResults() {
		return results;
	}

	public void setResults(double results) {
		this.results = results;
	}


}
