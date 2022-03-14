/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.repo;

import com.test.entities.Orders;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cris John Alonzaga
 */
@Repository
@Service
public class OrdersDao implements Dao<Orders> {

    private static List<Orders> orders = new ArrayList<>();
    
    @Autowired
    private SessionFactory sessionFactory;

//    public void saveOrders(Orders orders){
//        Session s = sessionFactory.getCurrentSession();
//        s.beginTransaction();
//
//        s.save(orders);
//        s.getTransaction().commit();
//        
//    }
//    
//    @SuppressWarnings({ "deprecation", "unchecked" })
//    public List<Orders> getAll(){
//        Session session = sessionFactory.getCurrentSession();
//
//        List<Orders> ordersList = session.createCriteria(Orders.class).list();
//
//        return ordersList;
//    }

    @Override
    public List<Orders> getAll() {
        return orders;
    }

    @Override
    public Optional<Orders> get(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Orders order) {

          //orders.add(order);
        if(order == null){
            System.out.println("haha null");
        }
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        s.save(order);
        s.getTransaction().commit();
    }

    public void addOnCart(Orders order){
        orders.add(order);
    }

    @Override
    public void save(List<Orders> orders){
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();

        for(Orders order : orders){
            if(order instanceof Orders){
                s.save(order);
                System.out.println(order.getProductName());
            }
        }

        s.getTransaction().commit();

        //throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void update(Orders t, String param) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(Orders t) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void remove(int index){
        orders.remove(index);
    }
}
