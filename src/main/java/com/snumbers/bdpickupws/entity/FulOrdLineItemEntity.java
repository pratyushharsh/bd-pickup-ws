package com.snumbers.bdpickupws.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "FUL_ORD_LINE_ITEM", schema = "SIM14")
public class FulOrdLineItemEntity {

    @Id
    @Column(name = "ID")
    Long id;

    @Column(name = "FUL_ORD_ID")
    Long fulOrdId;

    @Column(name = "ITEM_ID")
    String itemId;

    @Column(name = "SUBSTITUTE_LINE_ITEM_ID")
    Long substituteLineItemId;

    @Column(name = "PREFERRED_UOM")
    String preferedUom;

    @Column(name = "COMMENTS")
    String comments;

    @Column(name = "CREATE_DATE")
    Date createDate;

    @Column(name = "UPDATE_DATE")
    Date updateDate;

    @Column(name = "QUANTITY_ORDERED")
    Double orderedQuantity;

    @Column(name = "QUANTITY_PICKED")
    Double quantityPicked;

    @Column(name = "QUANTITY_DELIVERED")
    Double quanityDelivered;

    @Column(name = "QUANTITY_CANCELED")
    Double quantityCancelled;

    @Column(name = "QUANTITY_RESERVED")
    Double quantityReserved;

    @Column(name = "ALLOW_SUBSTITUTION")
    String allowSubstitution;

    @Column(name = "UNIT_COST_VALUE")
    String unitCostValue;

    @Column(name = "UNIT_COST_CURRENCY")
    String unitCostCurrency;
}
