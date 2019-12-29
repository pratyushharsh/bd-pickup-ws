package com.snumbers.bdpickupws.service;

import com.snumbers.bdpickupws.entity.AtgFulOrdPickAssignEntity;
import com.snumbers.bdpickupws.entity.AtgPickOrderView;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import com.snumbers.bdpickupws.ui.model.request.PickUpdateRequest;
import com.snumbers.bdpickupws.ui.model.response.PickOrderResponseModel;

import java.util.List;

public interface OrderService {

    List<PickLineItemEntity> getPickOrderDetail(long pickId);

    List<AtgPickOrderView> findAllByPickUser(String user);

    List<AtgPickOrderView> findOrderByUserAndStatus(String user, Long status);

    PickLineItemEntity updatePickQuantity(PickUpdateRequest request);
}
