package com.snumbers.bdpickupws.service.impl;

import com.snumbers.bdpickupws.repository.AtgFulfilmentRepository;
import com.snumbers.bdpickupws.repository.PickOrderDetailRepository;
import com.snumbers.bdpickupws.service.OrderService;
import com.snumbers.bdpickupws.entity.AtgFulOrdPickAssignEntity;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import com.snumbers.bdpickupws.ui.model.response.PickOrderResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private PickOrderRepository pickOrderRepo;

    @Autowired
    private PickOrderDetailRepository pickOrderDetailRepository;

    @Autowired
    private AtgFulfilmentRepository pickRepo;

//    @Override
//    public List<PickOrderDto> getOrdersByUser(String user) {
//        List<PickOrderDto> result = new ArrayList<>();
//        Iterable<PickOrderDto> odIter =  pickOrderRepo.findByPick__user__id(user);
//        for (PickOrderDto o: odIter) {
//            result.add(o);
//        }
//        return result;
//    }

    @Override
    public List<PickLineItemEntity> getPickOrderDetail(long pickId) {
        return pickOrderDetailRepository.findallbyfulOrdPickId(pickId);
    }

    @Override
    public List<PickOrderResponseModel> getAllPicks(String userId) {
        List<AtgFulOrdPickAssignEntity> qr = pickRepo.findAllByPickUser(userId);
        List<PickOrderResponseModel> result = new ArrayList<>();
        for (AtgFulOrdPickAssignEntity e: qr) {
            PickOrderResponseModel pm = new PickOrderResponseModel();
            pm.setOrderDate(e.getCreate_date());
            pm.setPickId(e.getPick_id());
            pm.setDeleveryStatus(e.getOrder().getStatus());
            pm.setDeliveryType(e.getOrder().getDelivery_type());
            pm.setFulfilmentId(e.getFul_ord_id());
            pm.setShipCarrierId(e.getOrder().getShip_carrier_id());
            pm.setCustomerOrderId(e.getOrder().getCust_order_id());
            pm.setCustomerId(e.getOrder().getCustomer_id());
            pm.setStoreId(e.getOrder().getStore_id());
            pm.setDepartment(e.getDepartment());
            pm.setTotalLineItems(e.getLineItem().size());
            int t = 0;
            for (PickLineItemEntity ie: e.getLineItem()) {
                t += ie.getQuantity_suggested();
            }
            pm.setTotalQuantity(t);
            result.add(pm);
        }
        return result;
    }

    @Override
    public AtgFulOrdPickAssignEntity getCompleteOrderByPickId(String pickUser, Long pickId) {
        return pickRepo.findByPick_UserAndPick_Id(pickUser, pickId);
    }
}
