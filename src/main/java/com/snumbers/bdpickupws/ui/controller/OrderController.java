package com.snumbers.bdpickupws.ui.controller;

import com.snumbers.bdpickupws.service.OrderService;
import com.snumbers.bdpickupws.entity.AtgFulOrdPickAssignEntity;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import com.snumbers.bdpickupws.ui.model.response.PickOrderResponseModel;
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


//    @GetMapping("user/{userId}")
//    public List<PickOrderDto> getOrders(@PathVariable("userId") String userId) {
//        return orderService.getOrdersByUser(userId);
//    }

    @GetMapping("pick/{pickuser}")
    public List<PickOrderResponseModel> getPicks(@PathVariable("pickuser") String pickuser) {
        return orderService.getAllPicks(pickuser);
    }

    @GetMapping("pickId/{pickId}")
    public List<PickLineItemEntity> getOrderItem(@PathVariable("pickId") Long pickId) {
        return orderService.getPickOrderDetail(pickId);
    }

    @GetMapping("pick/{pickuser}/pickId/{pickId}")
    public AtgFulOrdPickAssignEntity getFullOrderDetail(@PathVariable("pickuser") String pickUser,
                                                        @PathVariable("pickId") Long pickId) {
        return orderService.getCompleteOrderByPickId(pickUser, pickId);
    }

}
