/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controllers;

import com.test.entities.Orders;
import com.test.repo.OrdersDao;
import com.test.repo.OrdersList;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cris John Alonzaga
 */
@Controller
public class CheckoutController {
    private OrdersDao ordersDao = new OrdersDao();
    private Orders ord = new Orders();

    @RequestMapping("/checkout")
    public String burgers(Model model){
        
        model.addAttribute("orders" , ordersDao.getAll());

        //System.out.println(ordersDao.getAll());

        return "checkout";
    }
    
}
