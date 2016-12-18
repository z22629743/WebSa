package com.sample.product.entity;

import java.sql.Date;

public class Product {
    private long id;
    private long supplierId;
    private String name;
    private String color;
    private String size;
    private String category;
    private String desc;
    private int inventory;
    private int reorderPoint;
    private int price;
    private int discount;
    /* getters and setters */
    public long getId(){
            return id;
    }
    public void setId(long id){
    	this.id = id;
    }

    public String getCategory(){
            return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    
    public String getDesc(){
        return desc;
    }
    public void setDesc(String desc){
    	this.desc = desc;
    }

    public int getInventory(){
    		return inventory;
    }
    public void setInventory(int inventory){
		this.inventory = inventory;
    }
    
    public int getReorderPoint(){
    		return reorderPoint;
    }
    public void setReorderPoint(int reorderPoint){
		this.reorderPoint = reorderPoint;
    }
  
    public int getPrice() {
		return price;
	}
    public void setPrice(int price) {
		this.price = price;
	}
    public int getDiscount() {
		return discount;
	}
    public void setDiscount(int discount) {
		this.discount = discount;
	}
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
}//Product

