package com.snumbers.bdpickupws.service.impl;

import com.snumbers.bdpickupws.entity.AtgPickOrderView;
import com.snumbers.bdpickupws.repository.AtgPickOrderRepository;
import com.snumbers.bdpickupws.repository.PickOrderDetailRepository;
import com.snumbers.bdpickupws.service.OrderService;
import com.snumbers.bdpickupws.entity.PickLineItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private PickOrderRepository pickOrderRepo;

    @Autowired
    private PickOrderDetailRepository pickOrderDetailRepository;

    @Autowired
    private AtgPickOrderRepository atgPickRepo;

    @Override
    public List<PickLineItemEntity> getPickOrderDetail(long pickId) {
        return pickOrderDetailRepository.findallbyfulOrdPickId(pickId);
    }

    @Override
    public List<AtgPickOrderView> findAllByPickUser(String user) {
        return atgPickRepo.findAllByPickUser(user);
    }

    @Override
    public List<AtgPickOrderView> findOrderByUserAndStatus(String user, Long status) {
        return atgPickRepo.findAllByPickUserAndOrderStatus(user, status);
    }
}
