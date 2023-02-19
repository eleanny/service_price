package com.zara.app.price.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zara.app.price.models.entity.Price;
import com.zara.app.price.models.service.IPriceService;

/**
 * Class Controller. 
 * 
 * @author Eleanny Bastardo
 */
@RestController
@RequestMapping("/price")
public class PriceController {
	
	Logger logger = LoggerFactory.getLogger(PriceController.class);
	
	@Autowired
	private IPriceService iPriceService;
	
	
	public PriceController(IPriceService iPriceService) {
		
		this.iPriceService = iPriceService;
		
	}

	@GetMapping("/find/{dateApp}/{productId}/{brandId}")
	public ResponseEntity<Price> find( @PathVariable String dateApp, @PathVariable Integer productId, @PathVariable Integer brandId ) {
		
		logger.info("Start controller");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date;
		
		try 
		{
			date = dateFormat.parse(dateApp);
			Price price = iPriceService.findPrice(date, productId, brandId);
			
			if (price == null) {
				
				return new ResponseEntity<Price> (HttpStatus.NOT_FOUND);				
				
			}
			
			return new ResponseEntity<Price> (price, HttpStatus.OK);
			
		} 
		catch (ParseException e) 
		{
			
			logger.error("Error parsing date", e.getMessage());
			return new ResponseEntity<Price> (HttpStatus.BAD_REQUEST);
			
		} catch (SQLException e) {
			
			logger.error("Error SQL", e.getMessage());
			return new ResponseEntity<Price> (HttpStatus.BAD_REQUEST);
		}
		
	}
}
