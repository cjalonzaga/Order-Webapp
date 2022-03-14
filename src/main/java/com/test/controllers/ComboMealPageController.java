/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controllers;

import com.test.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Cris John Alonzaga
 */
@Controller
public class ComboMealPageController {
    
    private int categoryid;
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("combo-meal")
    public String burgers(Model model){
        categoryid = productRepository.getCategoryid();

        model.addAttribute("products", productRepository.getAllProductsFromCategory(categoryid));

        return "combo-meal";
    }

    @PostMapping(value="/combo-meal")
    public String setCatId(@RequestParam("category") String id, Model model){
    
        //System.out.println(id + " category id ");

        model.addAttribute( "products", productRepository.getAllProductsFromCategory(Integer.parseInt(id)));
        
        return "combo-meal";
    }
}
