package com.snumbers.bdpickupws.ui.controller;

import com.snumbers.bdpickupws.entity.AtgPickOrderView;
import com.snumbers.bdpickupws.service.OrderService;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("status/{status}/pick/{pickuser}")
    public List<AtgPickOrderView> getOrderByUserAndStatus(@PathVariable("status") Long status,
                                                          @PathVariable("pickuser") String pickuser) {
        return orderService.findOrderByUserAndStatus(pickuser, status);
    }

    @GetMapping("pick/{pickuser}")
    public List<AtgPickOrderView> getAllPicks(@PathVariable("pickuser") String pickuser) {
        return orderService.findAllByPickUser(pickuser);
    }

    @GetMapping("pickId/{pickId}")
    public List<PickLineItemEntity> getOrderItem(@PathVariable("pickId") Long pickId) {
        return orderService.getPickOrderDetail(pickId);
    }

}
