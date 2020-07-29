
package com.universal.dto;


import java.sql.Timestamp;
import java.util.ArrayList;

public class Order {
    private int orderid;
    private String flatno;
    private String streetName;
    private String area;
    private String city;
    private String landmark;
    private int totalcost;
    private ArrayList foodList;
    private Timestamp orderdate;
    private int userid;


    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getFlatno() {
        return flatno;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

   
    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public ArrayList getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList foodList) {
        this.foodList = foodList;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTotalcost() {
        return totalcost;
    }

   
    public void setTotalcost(int totalcost) {
        this.totalcost = totalcost;
    }

    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", flatno=" + flatno + ", streetName=" + streetName + ", area=" + area + ", city=" + city + ", landmark=" + landmark + ", totalcost=" + totalcost + ", foodList=" + foodList + ", orderdate=" + orderdate + ", userid=" + userid + '}';
    }
    
      
}
