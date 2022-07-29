/**
 * 
 */
package com.website.App.bean;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author 10698333
 *
 */
@Entity
@Table(name="ProductDetails")
public class ProductDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4672999022232759610L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="productName")
	private String productName;
	@Column(name="price")
	private double price;
	@Column(name="descripation")
	private String descripation;
	@Column(name="quantity")
	private Integer quantity;
	@Lob    
	@Column(name="image")
	private byte[] image;
	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the descripation
	 */
	public String getDescripation() {
		return descripation;
	}
	/**
	 * @param descripation the descripation to set
	 */
	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", productName=" + productName + ", price=" + price + ", descripation="
				+ descripation + ", quantity=" + quantity + ", image=" + Arrays.toString(image) + "]";
	}
	
	

}
