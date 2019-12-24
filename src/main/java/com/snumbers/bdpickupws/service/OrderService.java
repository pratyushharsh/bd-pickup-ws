package com.snumbers.bdpickupws.service;

import com.snumbers.bdpickupws.entity.AtgFulOrdPickAssignEntity;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import com.snumbers.bdpickupws.ui.model.response.PickOrderResponseModel;

import java.util.List;

public interface OrderService {

//    public List<PickOrderDto> getOrdersByUser(String user);

    public List<PickLineItemEntity> getPickOrderDetail(long pickId);

    public List<PickOrderResponseModel> getAllPicks(String userId);

    public AtgFulOrdPickAssignEntity getCompleteOrderByPickId(String pickUser, Long pickId);
}
