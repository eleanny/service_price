package com.zara.app.price.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Class Entity. 
 * 
 * @author Eleanny Bastardo
 */
@Entity
@Table( name = "Prices" )
public class Price implements Serializable{
	
	private static final long serialVersionUID = 7949254682889714155L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( name= "brand_id")
	private  Integer brandId;
	
	@Column( name= "brand_name")
	private  String brandName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name= "start_date")
	private  Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column( name= "end_date")
	private  Date endDate;

	@Column( name= "price_list")
	private  Integer priceList;
	
	@Column( name= "product_id")
	private  Integer productId;
	
	private  Integer priority;
	
	private  Double price;
	
	private  String curr;
	
	
	
	public Price() {
		super();
	}

	public Price(Integer brandId, Date startDate, Integer productId) {
		this.brandId = brandId;
		this.startDate = startDate;
		this.productId = productId;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Integer getPriceList() {
		return priceList;
	}
	
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}
	
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	
	

}
