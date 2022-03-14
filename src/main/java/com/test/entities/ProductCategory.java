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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Cris John Alonzaga
 */
@Entity
@Table (name="product_category")
@Getter @Setter @NoArgsConstructor
@Data
public class ProductCategory implements Serializable {

//    @ManyToOne
//    private Products products;
//
//    @ManyToOne
//    private Category category;

    @Id
    @Column(name="prodcatid")
    private int prodcatid;
    
    @Column(name="product_id")
    private int productId;

    @Column(name="cat_id")
    private int catId;
    
//    @ManyToOne
//    private Category category;
//    
//    @ManyToOne
//   // @JoinColumn(name = "id", referencedColumnName = "id")
//    private Products products;

    public ProductCategory(int prodcatid, int productId, int catId) {
        this.prodcatid = prodcatid;
        this.productId = productId;
        this.catId = catId;
    }
    
}
