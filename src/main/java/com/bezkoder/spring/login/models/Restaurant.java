package com.bezkoder.spring.login.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants_cards")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String rest_name;
	private String rest_address;
	private String ratings;
	private String delivery_time;
	private String cost;
	private String image_Url;
	
	private String rest_menulink;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRest_name() {
		return rest_name;
	}
	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}
	public String getRest_address() {
		return rest_address;
	}
	public void setRest_address(String rest_address) {
		this.rest_address = rest_address;
	}
	public String getRatings() {
		return ratings;
	}
	public void setRatings(String ratings) {
		this.ratings = ratings;
	}
	public String getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getImage_Url() {
		return image_Url;
	}
	public void setImage_Url(String image_Url) {
		this.image_Url = image_Url;
	}
	public String getRest_menulink() {
		return rest_menulink;
	}
	public void setRest_menulink(String rest_menulink) {
		this.rest_menulink = rest_menulink;
	}
	public Restaurant(int id, String rest_name, String rest_address, String ratings, String delivery_time, String cost,
			String image_Url, String rest_menulink) {
		super();
		this.id = id;
		this.rest_name = rest_name;
		this.rest_address = rest_address;
		this.ratings = ratings;
		this.delivery_time = delivery_time;
		this.cost = cost;
		this.image_Url = image_Url;
		this.rest_menulink = rest_menulink;
	}
	public Restaurant() {
		super();
	}
	
	
}
