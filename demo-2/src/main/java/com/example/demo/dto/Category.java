package com.example.demo.dto;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

	@Id
	private int cid;
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	private List<Product>products;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Category(int cid, String name, List<Product> products) {
		super();
		this.cid = cid;
		this.name = name;
		this.products = products;
	}
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "Category [cid=" + cid + ", name=" + name + "]";
	}
	
	

	


}