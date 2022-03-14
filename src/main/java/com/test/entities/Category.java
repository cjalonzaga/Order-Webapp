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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Cris John Alonzaga
 */
@Entity
@Setter @Getter @NoArgsConstructor
public class Category implements Serializable {

    @Id
    @Column (name="category_id")
    private int categoryid;

    @Column (name="category_name")
    private String categoryName;

    @Column (name="category_thumb")
    private String categoryThumb;

    @Column (name="slug")
    private String categorySlug;

    public Category(int categoryid, String categoryName, String categoryThumb) {
        this.categoryid = categoryid;
        this.categoryName = categoryName;
        this.categoryThumb = categoryThumb;
    }
}
