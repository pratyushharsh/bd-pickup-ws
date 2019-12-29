package com.snumbers.bdpickupws.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserDashBoardDto implements Serializable {

    String userId;
    Long newOrder;
    Long inProgressOrder;
    Long completedOrder;
    Long cancelledOrder;
    Long activeOrders;
}
