package za.co.mmi.converter.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.pattern.Converter;
import za.co.mmi.converter.api.ConverterDto;

@Service
public class ConverterSeriveImpl implements ConverterService {

	private final Logger logger = LoggerFactory.getLogger(ConverterSeriveImpl.class);



	@Override
	public ConverterDto converter(ConverterDto converterDto) {
		
		 if(converterDto.getConvertTo().equalsIgnoreCase("kilometers") || converterDto.getConvertTo().equalsIgnoreCase("yards")){
			 converterDto= distanceConverter(converterDto);
		 } 
		 else if(converterDto.getConvertTo().equalsIgnoreCase("liters") || converterDto.getConvertTo().equalsIgnoreCase("gallons")) {
			 converterDto= volumeConverter(converterDto);
		 } 
		 else {
			 converterDto= weightConverter(converterDto);
		 }
		
		return converterDto;
		
	}

	public ConverterDto volumeConverter(ConverterDto converterDto) {
		double convertedValue =0.0;
		if(converterDto.getConvertFrom().equalsIgnoreCase("Liters")) {
			convertedValue = converterDto.getValue() * 0.264;
			converterDto.setResults(convertedValue);
		}else {
			convertedValue = converterDto.getValue() / 0.264;
			converterDto.setResults(convertedValue);
		}
		return converterDto;
	}
	public ConverterDto distanceConverter(ConverterDto converterDto){
		double convertedValue =0.0;
		if(converterDto.getConvertFrom().equalsIgnoreCase("Kilometers")) {
			convertedValue = converterDto.getValue() * 1093.6;
			converterDto.setResults(convertedValue);
		}else {
			convertedValue =converterDto.getValue() / 1093.6;
			converterDto.setResults(convertedValue);
		}
		return converterDto;
	      
		
	}
	public ConverterDto weightConverter(ConverterDto converterDto) {
		double convertedValue =0.0;
		if(converterDto.getConvertFrom().equalsIgnoreCase("kilograms")) {
			convertedValue = converterDto.getValue() * 2.2;
			converterDto.setResults(convertedValue);
		}else {
			convertedValue =converterDto.getValue() / 2.2;
			converterDto.setResults(convertedValue);
		}
		return converterDto;	
	}

}
