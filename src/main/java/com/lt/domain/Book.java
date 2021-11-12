package com.lt.domain;

/**
 * Author: lt
 * Date: 2021/10/18 - 19:36
 **/

/**
 * 图书类
 */
public class Book {
    private int id;     //图书id号
    private String name;    //图书名字
    private double price;   //图书价格
    private String author;  //图书作者
    private String type;    //图书类别
    private String pdate;   //图书日期
    private String description;     //图书简介
    private String detail;  //图书详细描述
    private String address;     //图书生产编号

    public Book() {
    }

    public Book(int id, String name, double price, String author, String type,
                String pdate, String description, String detail, String address) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.type = type;
        this.pdate = pdate;
        this.description = description;
        this.detail = detail;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
