package com.zara.app.price.models.service;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zara.app.price.models.dao.PriceDao;
import com.zara.app.price.models.entity.Price;

/**
 * Class Service. 
 * 
 * @author Eleanny Bastardo
 */
@Service
public class PriceServiceImplement implements IPriceService{
	
	@Autowired
	private PriceDao priceDao;

	@Override
	@Transactional(readOnly = true)
	public Price findPrice(Date dateApp, Integer productId, Integer brandId) throws SQLException {
		
		return priceDao.findPrice(dateApp, productId, brandId);
	}

}
