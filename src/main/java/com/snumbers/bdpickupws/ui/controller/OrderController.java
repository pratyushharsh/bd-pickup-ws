package com.snumbers.bdpickupws.ui.controller;

import com.snumbers.bdpickupws.entity.AtgPickOrderView;
import com.snumbers.bdpickupws.service.OrderService;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import com.snumbers.bdpickupws.ui.model.request.PickUpdateRequest;
import com.snumbers.bdpickupws.ui.model.response.PickUpdateResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("pickId/{pickId}")
    public PickUpdateResponse updatePickQuantity(@RequestBody PickUpdateRequest request, @PathVariable("pickId") Long pickId) {
        PickUpdateResponse resp = new PickUpdateResponse();
        PickLineItemEntity pick = orderService.updatePickQuantity(request);
        BeanUtils.copyProperties(pick, resp);
        return resp;
    }
}
