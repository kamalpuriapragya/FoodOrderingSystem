package com.universal.dto;


import java.io.InputStream;
import java.sql.Timestamp;



public class FoodMenu {
    
    private int food_id;
    private String food_name;
    private String category;
    private int price;
    private int quantity;
    private String description;
    private InputStream image;
    private Timestamp orderdate;

   
    @Override
    public String toString() {
        return "FoodMenu{" + "food_name=" + food_name + ", orderdate=" + orderdate + ", category=" + category + ", price=" + price + ", quantity=" + quantity + ", description=" + description + ", image=" + image + '}';
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

   
    public int getFood_id() {
        return food_id;
    }
    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }
    public InputStream getImage() {
        return image;
    }
    public void setImage(InputStream inputStream) {
        image=inputStream;
    }
}
