/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controllers;


import com.test.repo.OrdersDao;
import com.test.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 *
 * @author Cris John Alonzaga
 */
@Controller
public class HomeController {

    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("categories", productRepository.getCategories());

        return "home";
    }

}
