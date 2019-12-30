package com.snumbers.pickupws.ui.model.request;

import lombok.Data;

@Data
public class PickUpdateRequest {
    Long id;
    String itemId;
    Long orderPickId;
    Long fulfilmentId;
    Long orderLineItemId;
    Double quantitySuggested;
    Double quantityPickedInit;
    Double quantityPickedFinal;
}
