package com.zara.app.price.models.service;

import java.sql.SQLException;
import java.util.Date;

import com.zara.app.price.models.entity.Price;

public interface IPriceService {
	
	public Price findPrice(Date dateApp, Integer productId, Integer brandId) throws SQLException;

}
