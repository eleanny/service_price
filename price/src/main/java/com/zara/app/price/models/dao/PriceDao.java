
package com.zara.app.price.models.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zara.app.price.models.entity.Price;

/**
 * Class Repository. 
 * 
 * @author Eleanny Bastardo
 */
@Repository
public class PriceDao{
	
	
	private EntityManager entityManager;
	
	
	@Autowired
	public PriceDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	public Price findPrice(Date dateApp, Integer productId, Integer brandId) throws SQLException{
		
		String hlq = "SELECT p.brandId, p.brandName, p.startDate, p.endDate, p.productId, MAX(p.priority), p.price FROM Price p WHERE p.startDate<=:dateApp AND p.endDate>=:dateApp AND p.productId=:pproductId AND p.brandId=:pbrandId "
				    + "group by brandId, startDate, endDate, priceList, productId" ;
		Query query = (Query)entityManager.createQuery(hlq);
		query.setParameter("dateApp", dateApp);
		query.setParameter("pproductId", productId);
		query.setParameter("pbrandId", brandId);
		List<Object[]> result= query.list();
		
		if( !result.isEmpty()) {
			return convertResult(result);
		}
		
		return null;
	}
		
	private Price convertResult(List<Object[]> list) {
		
		Price response = new Price();
		
		for(Object[] row : list) {
			
			response.setBrandId(Integer.valueOf(row[0].toString()));
			response.setBrandName(row[1].toString());
			response.setStartDate((Date)row[2]);
			response.setEndDate((Date)row[3]);
			response.setProductId(Integer.valueOf(row[4].toString()));
			response.setPriority(Integer.valueOf(row[5].toString()));
			response.setPrice(Double.valueOf(row[6].toString()));
			
		}
		
		return response;
	}
		
	
	

}
