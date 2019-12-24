package com.snumbers.bdpickupws.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "ATG_FUL_ORD_PICK_ASSIGN", schema = "SIM14")
public class AtgFulOrdPickAssignEntity {

    @Id
    private Long pick_id;
    private Long store_id;
    private Date create_date;
    private String pick_user_id;
    @Column(name = "ful_ord_id", insertable = false, updatable = false)
    private Long ful_ord_id;
    private String department;
    private Long status;
    private String field1;
    private String field2;
    private String remarks;

    @OneToOne
    @JoinColumn(name = "ful_ord_id", referencedColumnName = "id")
    private FulOrdEntity order;

    @OneToMany
    @JoinColumn(name = "ful_ord_pick_id", referencedColumnName = "pick_id")
    private Set<PickLineItemEntity> lineItem;
}
