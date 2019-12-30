package com.snumbers.pickupws.ui.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class PickOrderResponseModel {
    private Date orderDate;
    private Long pickId;
    private Integer deliveryType;
    private Integer deleveryStatus;
    private Long fulfilmentId;
    private Long shipCarrierId;
    private String customerOrderId;
    private String customerId;
    private Long storeId;
    private String department;
    private Integer totalQuantity;
    private Integer totalLineItems;
}
