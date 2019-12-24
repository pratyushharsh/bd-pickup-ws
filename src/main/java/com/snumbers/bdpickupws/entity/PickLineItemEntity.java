package com.snumbers.bdpickupws.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "FUL_ORD_PICK_LINE_ITEM", schema = "SIM14")
public class PickLineItemEntity {

    @Id
    private Long id;

    @Column(name = "item_id", insertable = false, updatable = false)
    private String item_id;
    private Long ful_ord_pick_id;
    private Long ful_ord_id;
    private Long ful_ord_line_item_id;
    private Long substitute_line_item_id;
    private String preferred_uom;
    private Double quantity_suggested;
    private Double quantity_picked;
    private Double case_size;
    private Integer line_item_ordinal;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private ItemEntity item;
}
