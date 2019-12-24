package com.snumbers.bdpickupws.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "ful_ord", schema = "SIM14")
public class FulOrdEntity {

    @Id
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
    private Double ship_cost_value;
    private String ship_cost_currency;
}
