package com.bezkoder.spring.login.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mcdonald_menu")
public class Mcdonald_menu {
	@Id
	public int food_id;
	public String food_name;
	public String food_cost;
	public String food_categorie;
	public String food_disc;
	public String food_image;
	
	public Mcdonald_menu() {
		super();
	}
	public Mcdonald_menu(int food_id, String food_name, String food_cost, String food_categorie, String food_disc,
			String food_image) {
		super();
		this.food_id = food_id;
		this.food_name = food_name;
		this.food_cost = food_cost;
		this.food_categorie = food_categorie;
		this.food_disc = food_disc;
		this.food_image = food_image;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getFood_cost() {
		return food_cost;
	}
	public void setFood_cost(String food_cost) {
		this.food_cost = food_cost;
	}
	public String getFood_categorie() {
		return food_categorie;
	}
	public void setFood_categorie(String food_categorie) {
		this.food_categorie = food_categorie;
	}
	public String getFood_disc() {
		return food_disc;
	}
	public void setFood_disc(String food_disc) {
		this.food_disc = food_disc;
	}
	public String getFood_image() {
		return food_image;
	}
	public void setFood_image(String food_image) {
		this.food_image = food_image;
	}
}
