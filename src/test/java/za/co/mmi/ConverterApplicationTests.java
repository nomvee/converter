package za.co.mmi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import za.co.mmi.converter.api.ConverterDto;
import za.co.mmi.converter.service.ConverterSeriveImpl;
import za.co.mmi.converter.service.ConverterService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterApplicationTests {
	@TestConfiguration
	@Ignore
	static class ConverterSESConfig{
		
		@Bean
		public ConverterService converterService() {
			return new ConverterSeriveImpl();
		}
	}
	
	@Autowired
	private ConverterService converterService;
	private static DecimalFormat df2 = new DecimalFormat("0.00");

	@Test
	public void whenConvertingYard_thenReturnKilometersValue() {
		
		
		double kilometerResults =  3424 / 1093.6;
		kilometerResults = 3.13;
		
		 ConverterDto convert = new ConverterDto();
		    convert.setConvertFrom("Yards");
		    convert.setConvertTo("Kilometers");
		    convert.setValue(3424);
		    
			ConverterDto results = converterService.converter(convert);
		    BigDecimal bd = new BigDecimal(results.getResults());
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			assertEquals(kilometerResults,bd.doubleValue(),0.0);
		
		
		
	}

	
	@Test
	public void whenConvertingKilograms_thenReturnPoundValue() {
		
		double poundResults =  25 * 2.2;
		poundResults = 55.00;
		
		 ConverterDto convert = new ConverterDto();
		    convert.setConvertFrom("kilograms");
		    convert.setConvertTo("pound");
		    convert.setValue(25);
		    
			ConverterDto results = converterService.converter(convert);
		    BigDecimal bd = new BigDecimal(results.getResults());
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			assertEquals(poundResults,bd.doubleValue(),0.0);
		
	}
	
	
	@Test
	public void whenConvertingLiter__thenReturnGallonValue() {
		
		double galloResults =  25 * 0.264;
		galloResults = 6.60;
		 ConverterDto convert = new ConverterDto();
		    convert.setConvertFrom("liters");
		    convert.setConvertTo("gallons");
		    convert.setValue(25);
		    ConverterDto results = converterService.converter(convert);
		    BigDecimal bd = new BigDecimal(results.getResults());
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		    assertEquals(galloResults, bd.doubleValue(),0.0);

		
	}
	
	
	
	
}




 
