package com.snumbers.bdpickupws.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//@Table(name = "pick_order")
//@Entity
//@Data
public class PickOrderEntity {

//    @Id
    private Long pick_id;
    private String pick_user_id;
    private Long id;
    private String external_id;
    private String cust_order_id;
    private Long store_id;
    private String customer_id;
    private Integer order_type;
    private Integer delivery_type;
    private Integer status;
    private String comments;
    private Date cust_order_date;
    private Date create_date;
    private Date update_date;
    private Date release_date;
    private Date delivery_date;
    private Long ship_carrier_id;
    private Long ship_carrier_service_id;
    private String allow_partial_delivery;
    private String department;
    private Long total_quantity;
}
