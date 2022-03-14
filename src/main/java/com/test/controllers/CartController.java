/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controllers;

import com.test.entities.Orders;
import com.test.repo.OrdersDao;
import com.test.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Cris John Alonzaga
 */
@Controller
public class CartController {

    private OrdersDao ordersDao = new OrdersDao();

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/cart")
    public String burgers(Model model){

       model.addAttribute("orders" , ordersDao.getAll());
        
        return "cart";
    }

    @PostMapping(value="/cart")
    public String setCatId(@RequestParam("order") String id, Model model){

        model.addAttribute( "products", productRepository.getProductData(Integer.parseInt(id)));
        
        return "cart";
    }

    @RequestMapping(value="/getorders", method=RequestMethod.POST)
    public @ResponseBody String setOrders(@RequestParam(value="productid") String id, @RequestParam(value="prodname") String name, 
    @RequestParam(value="quantity") String qty, @RequestParam(value="price") String price){
        
        Orders or = new Orders();
        or.setProductid(Integer.parseInt(id));
        or.setQuantity(Integer.parseInt(qty));
        or.setTotalprice(Integer.parseInt(price));
        or.setTotaltax((Integer.parseInt(price) * 0.13));
        or.setProductName(name);

        ///System.out.println(id+" "+name+" "+qty);
        
        ordersDao.addOnCart(or);
                                  

        return "cart";              
    }

    @RequestMapping(value="/remove", method=RequestMethod.POST)
    public @ResponseBody String removeOrder(@RequestParam(value="indexnum") String index){
        
        int indexnum = Integer.parseInt(index);

        ordersDao.remove(indexnum);

        return "cart";
    }
}
