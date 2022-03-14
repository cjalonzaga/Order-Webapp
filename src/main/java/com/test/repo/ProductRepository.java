/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.repo;

import com.test.entities.Category;
import com.test.entities.ProductCategory;
import com.test.entities.Products;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cris John Alonzaga
 */
@Repository
@Setter @Getter
public class ProductRepository {

    private int categoryid;

    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public List getCategories(){
//        System.out.println(id+" Hello Spring");
        //catId = id;
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Category c");
        List<Category> prodCat = query.getResultList();

        return prodCat;
        //return sessionFactory.createQuery("SELECT prod FROM Products prod inner join ProductCategory as prodcat on prod.id=prodcat.productId WHERE prodcat.catId="+id).getResultList();
    }

    @Transactional
    public List getAllProductsFromCategory(int catid){
        
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT prod FROM Products prod inner join ProductCategory as prodcat on prod.id=prodcat.productId WHERE prodcat.catId="+catid);
        
        List<Products> products = query.getResultList();

        return products;
    }

    @Transactional
    public List getProductData(int productid){

        Query query = sessionFactory.getCurrentSession().createQuery("SELECT prod FROM Products prod WHERE prod.id="+productid);
        
        List<Products> products = query.getResultList();

        return products;
    }
    
}

