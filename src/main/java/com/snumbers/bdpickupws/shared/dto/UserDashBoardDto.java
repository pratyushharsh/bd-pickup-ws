package com.snumbers.bdpickupws.shared.dto;

import lombok.Data;

@Data
public class UserDashBoardDto {

    String userId;
    Long newOrder;
    Long inProgressOrder;
    Long completedOrder;
    Long cancelledOrder;
    Long activeOrders;
}
