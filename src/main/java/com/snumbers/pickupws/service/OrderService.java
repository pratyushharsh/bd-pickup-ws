package com.snumbers.pickupws.service;

import com.snumbers.pickupws.entity.AtgPickOrderView;
import com.snumbers.pickupws.entity.PickLineItemEntity;
import com.snumbers.pickupws.ui.model.request.PickUpdateRequest;

import java.util.List;

public interface OrderService {

    List<PickLineItemEntity> getPickOrderDetail(long pickId);

    List<AtgPickOrderView> findAllByPickUser(String user);

    List<AtgPickOrderView> findOrderByUserAndStatus(String user, Long status);

    PickLineItemEntity updatePickQuantity(PickUpdateRequest request);
}
