/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.repo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.entities.Orders;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Cris John Alonzaga
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter @Getter
public class OrdersList {
    private List<Orders> orderList;
}
