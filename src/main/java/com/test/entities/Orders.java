package com.test.entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Cris John Alonzaga
 */
@Entity
@Setter @Getter @NoArgsConstructor
@Table(name="orders")
public class Orders implements Serializable {
    
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;

    @Column(name="product_id")
    private int productid;

    @Column(name="product_name")
    private String productName;

    @Column(name="quantity")
    private int quantity;

    @Column(name="total_price")
    private int totalprice;

    @Column(name="customer_id")
    private int customerid;

    @Column(name="total_tax")
    private double totaltax;

    public Orders(int orderid, int productid, int quantity, int totalprice, int customerid, double totaltax) {
        this.orderid = orderid;
        this.productid = productid;
        this.quantity = quantity;
        this.totalprice = totalprice;
        this.customerid = customerid;
        this.totaltax = totaltax;
    }
}
