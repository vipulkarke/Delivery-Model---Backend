package com.bezkoder.spring.login.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Menu {
	@Id
	int food_id ;
	  
	int fk_id ;
	String food_name;
	String food_disc;
	BigDecimal food_cost ;
	String food_image;
	String food_categorie;
	
	
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public int getFk_id() {
		return fk_id;
	}
	public void setFk_id(int fk_id) {
		this.fk_id = fk_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_disc() {
		return food_disc;
	}
	public void setFood_disc(String food_disc) {
		this.food_disc = food_disc;
	}
	public BigDecimal getFood_cost() {
		return food_cost;
	}
	public void setFood_cost(BigDecimal food_cost) {
		this.food_cost = food_cost;
	}
	public String getFood_image() {
		return food_image;
	}
	public void setFood_image(String food_image) {
		this.food_image = food_image;
	}
	public String getFood_categorie() {
		return food_categorie;
	}
	public void setFood_categorie(String food_categorie) {
		this.food_categorie = food_categorie;
	}
	public Menu(int food_id, int fk_id, String food_name, String food_disc, BigDecimal food_cost, String food_image,
			String food_categorie) {
		super();
		this.food_id = food_id;
		this.fk_id = fk_id;
		this.food_name = food_name;
		this.food_disc = food_disc;
		this.food_cost = food_cost;
		this.food_image = food_image;
		this.food_categorie = food_categorie;
	}
	public Menu() {
		super();
	}
	
}
