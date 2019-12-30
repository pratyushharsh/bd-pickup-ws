package com.snumbers.pickupws.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item", schema = "SIM14")
public class ItemEntity {

    @Id
    private String item_id;
    private Long item_type;
    private Long department_id;
    private Long class_id;
    private Long subclass_id;
    private String short_description;
    private String long_description;
    private String differentiator_1;
    private String differentiator_2;
    private String differentiator_3;
    private String differentiator_4;
    private String status;
    private String order_as_type;
    private String parent_item_id;
    private Long transaction_level;
    private Long item_level;
    private String sellable;
    private String orderable;
    private String package_unit_of_measure;
    private Double package_size;
    private String unit_of_measure;
    private Double case_size;
    private String barcode_format;
    private Long barcode_prefix;
    private String ticket_type_code;
    private Double each_to_uom_factor;
    private String waste_type;
    private Double waste_percent;
    private Double waste_percent_default;
    private Character estimate_soh_for_pack;
    private String retail_zone_id;
    private Character is_primary;
    private String brand;
    private Double manu_suggested_retail_price;
}
