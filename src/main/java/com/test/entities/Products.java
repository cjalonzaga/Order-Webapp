/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table (name="products")
@Getter @Setter @NoArgsConstructor
public class Products implements Serializable {
    @Id
    @Column (name="id")
    private int id;
    
    @Column(name="product_name")
    private String productName;
    
    @Column (name="product_price")
    private int price;
    
    @Column (name="description")
    private String description;

    @Column (name="product_thumb")
    private String productThumb;


    public Products(int id, String productName, int price, String description) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
    }
}
