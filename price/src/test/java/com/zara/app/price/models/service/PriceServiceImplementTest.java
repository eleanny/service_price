package com.zara.app.price.models.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zara.app.price.models.entity.Price;

/**
 * Class Service Implement Test. 
 * 
 * @author Eleanny Bastardo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceServiceImplementTest {

	Logger logger = LoggerFactory.getLogger(PriceServiceImplementTest.class);
	
	@Autowired	
	private IPriceService iPriceService;

	@Test
	void test1() throws ParseException, SQLException {
		
		Integer productId = 35455;
		Integer brand = 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date  date = dateFormat.parse("2020-06-14 00:00:00");		
		
		Price found = iPriceService.findPrice(date, productId, brand);
		
		assertThat(found.getProductId()).isNotNull();
		
		logger.info(" Test 1: petición a las" + date + " del producto " + found.getProductId()+  " para la brand:" +found.getBrandId()+ " ("+found.getBrandName()+")");
	
	}
	
	@Test
	void test2() throws ParseException, SQLException {
		
		Integer productId = 35455;
		Integer brand = 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date  date = dateFormat.parse("2020-06-14 16:00:00");		
		
		Price found = iPriceService.findPrice(date, productId, brand);
		
		assertThat(found.getProductId()).isNotNull();
		
		logger.info(" Test 2: petición a las" + date + " del producto " + found.getProductId()+  " para la brand:" +found.getBrandId()+ " ("+found.getBrandName()+")");
	
	}
	
	@Test
	void test3() throws ParseException, SQLException {
		
		Integer productId = 35455;
		Integer brand = 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date  date = dateFormat.parse("2020-06-14 21:00:00");		
		
		Price found = iPriceService.findPrice(date, productId, brand);
		
		assertThat(found.getProductId()).isNotNull();
		
		logger.info(" Test 3: petición a las" + date + " del producto " + found.getProductId()+  " para la brand:" +found.getBrandId()+ " ("+found.getBrandName()+")");
	
	}
	
	@Test
	void test4() throws ParseException, SQLException {
		
		Integer productId = 35455;
		Integer brand = 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date  date = dateFormat.parse("2020-06-15 10:00:00");		
		
		Price found = iPriceService.findPrice(date, productId, brand);
		
		assertThat(found.getProductId()).isNotNull();
		
		logger.info(" Test 4: petición a las" + date + " del producto " + found.getProductId()+  " para la brand:" +found.getBrandId()+ " ("+found.getBrandName()+")");
	
	}
	
	@Test
	void test5() throws ParseException, SQLException {
		
		Integer productId = 35455;
		Integer brand = 1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date  date = dateFormat.parse("2020-06-16 21:00:00");		
		
		Price found = iPriceService.findPrice(date, productId, brand);
		
		assertThat(found.getProductId()).isNotNull();
		
		logger.info(" Test 5: petición a las" + date + " del producto " + found.getProductId()+  " para la brand:" +found.getBrandId()+ " ("+found.getBrandName()+")");
	
	}

}
