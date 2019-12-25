package com.snumbers.bdpickupws.service;

import com.snumbers.bdpickupws.entity.AtgFulOrdPickAssignEntity;
import com.snumbers.bdpickupws.entity.AtgPickOrderView;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import com.snumbers.bdpickupws.ui.model.response.PickOrderResponseModel;

import java.util.List;

public interface OrderService {

    public List<PickLineItemEntity> getPickOrderDetail(long pickId);

    public List<AtgPickOrderView> findAllByPickUser(String user);

    public List<AtgPickOrderView> findOrderByUserAndStatus(String user, Long status);
}
