/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.repo;

import com.test.entities.Orders;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cris John Alonzaga
 */
@RestController
@RequestMapping("/prodeed")
public class OrderRest {

    private OrdersDao ordersDao = new OrdersDao();

    @RequestMapping(value="/proceed", method=RequestMethod.POST)
    public @ResponseBody List<?> proceesOrder( @RequestBody List<Orders> order){

        ordersDao.save(order);
        return order;
    }
}
