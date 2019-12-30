package com.snumbers.pickupws.ui.model.response;

import lombok.Data;

@Data
public class PickUpdateResponse {

//    private boolean hasError;
//    private String errorMessage;
    private Long id;
    private String item_id;
    private Long ful_ord_pick_id;
    private Long ful_ord_id;
    private Double quantity_suggested;
    private Double quantity_picked;
    private Double case_size;
}
