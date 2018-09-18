package za.co.mmi.converter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.mmi.converter.api.ConverterDto;
import za.co.mmi.converter.service.ConverterSeriveImpl;

 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({ "/converter" })
public class ConverterResource {

	@Autowired
	private ConverterSeriveImpl ConverterService;

	private final Logger logger = LoggerFactory.getLogger(ConverterResource.class);



	@RequestMapping(method=RequestMethod.POST, headers="content-type=application/json")
	public ConverterDto convertValues(@RequestBody ConverterDto converterDto) {

		return ConverterService.converter(converterDto);
	}
	
	/*@GetMapping
	public String get() {
		return "Hellow Docker";
	}*/


	

}
