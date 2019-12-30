package com.snumbers.pickupws.entity;


import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Immutable
@Subselect("select * from sim14.ATG_PICK_ORDER_V")
public class AtgPickOrderView {

    @Id
    @Column(name = "pick_id", updatable = false, insertable = false)
    private Long pickId;

    @Column(name = "pick_user_id", updatable = false, insertable = false)
    private String pickUser;

    @Column(name = "id", updatable = false, insertable = false)
    private Long fulfilmentId;

    @Column(name = "cust_order_id", updatable = false, insertable = false)
    private String customerOrderId;

    @Column(name = "store_id", updatable = false, insertable = false)
    private Long storeId;

    @Column(name = "customer_id", updatable = false, insertable = false)
    private String customerId;

    @Column(name = "order_type", updatable = false, insertable = false)
    private Long orderType;

    @Column(name = "delivery_type", updatable = false, insertable = false)
    private Long deliveryType;

    @Column(name = "status", updatable = false, insertable = false)
    private Long orderStatus;

    @Column(name = "comments", updatable = false, insertable = false)
    private String comments;

    @Column(name = "cust_order_date", updatable = false, insertable = false)
    private Date customerOrderDate;

    @Column(name = "create_date", updatable = false, insertable = false)
    private Date orderDate;

    @Column(name = "ship_carrier_id", updatable = false, insertable = false)
    private Long shipCarrierId;

    @Column(name = "ship_carrier_service_id", updatable = false, insertable = false)
    private Long shipCarrierServiceId;

    @Column(name = "allow_partial_delivery", updatable = false, insertable = false)
    private String allowPartialDelivery;

    @Column(name = "department", updatable = false, insertable = false)
    private String department;

    @Column(name = "total_quantity", updatable = false, insertable = false)
    private Long totalQuantity;
}
