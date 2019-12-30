package com.snumbers.pickupws.service.impl;

import com.snumbers.pickupws.entity.AtgPickOrderView;
import com.snumbers.pickupws.exception.OrderServiceException;
import com.snumbers.pickupws.exception.PickUpdateException;
import com.snumbers.pickupws.repository.AtgPickOrderRepository;
import com.snumbers.pickupws.repository.PickOrderDetailRepository;
import com.snumbers.pickupws.service.OrderService;
import com.snumbers.pickupws.entity.PickLineItemEntity;
import com.snumbers.pickupws.ui.model.request.PickUpdateRequest;
import com.snumbers.pickupws.ui.model.response.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PickOrderDetailRepository pickOrderDetailRepository;

    @Autowired
    private AtgPickOrderRepository atgPickRepo;

    @Autowired
    JdbcTemplate jt;

    @Override
    public List<PickLineItemEntity> getPickOrderDetail(long pickId) {
        List<PickLineItemEntity> lineItemEntities;
        try {
            lineItemEntities = pickOrderDetailRepository.findallbyfulOrdPickId(pickId);
        } catch (Exception e) {
            // @TODO
            throw new OrderServiceException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
        }
        return lineItemEntities;
    }

    @Override
    public List<AtgPickOrderView> findAllByPickUser(String user)
    {
        return atgPickRepo.findAllByPickUser(user);
    }

    @Override
    public List<AtgPickOrderView> findOrderByUserAndStatus(String user, Long status) {
        List<AtgPickOrderView> result;
        try {
            result = atgPickRepo.findAllByPickUserAndOrderStatus(user, status);
        } catch (Exception e){
            // @TODO
            throw new OrderServiceException(ErrorMessages.INTERNAL_SERVER_ERROR.getErrorMessage());
        }
        return result;
    }

    @Override
    @Transactional
    public PickLineItemEntity updatePickQuantity(PickUpdateRequest request) {
        // Check the previous quantity
        PickLineItemEntity cur = getCurrentPickSnapShot(request.getId());

        if (    cur.getItem_id().compareTo(request.getItemId()) == 0 &&
                cur.getFul_ord_pick_id().compareTo(request.getOrderPickId()) == 0 &&
                cur.getFul_ord_line_item_id().compareTo(request.getOrderLineItemId()) == 0 &&
                cur.getQuantity_picked().compareTo(request.getQuantityPickedInit()) == 0 &&
                cur.getQuantity_suggested().compareTo(request.getQuantitySuggested()) == 0 &&
                cur.getQuantity_suggested().compareTo(request.getQuantityPickedFinal()) >= 0) {

            fulOrdLineItem(request.getQuantityPickedFinal(),
                    request.getOrderLineItemId(),
                    request.getFulfilmentId(),
                    request.getItemId());

            fulPickOrdLineItem(request.getQuantityPickedFinal(),
                    request.getId(),
                    request.getItemId(),
                    request.getOrderPickId(),
                    request.getFulfilmentId());
            return getCurrentPickSnapShot(request.getId());
        } else {
            // Handle the error if not
            throw new PickUpdateException(ErrorMessages.INVALID_INPUT_PARAMETERS.getErrorMessage());
        }
    }

    private PickLineItemEntity getCurrentPickSnapShot(Long id) {
        String SQL = "SELECT * FROM SIM14.FUL_ORD_PICK_LINE_ITEM where ID = ?";
        PickLineItemEntity e = jt.queryForObject(SQL, new Object[]{id}, new BeanPropertyRowMapper<>(PickLineItemEntity.class));
        return e;
    }

    private void fulOrdLineItem(Double quantityPicked, Long id, Long fulFilmentId, String itemId) {
        String SQL = "UPDATE SIM14.FUL_ORD_LINE_ITEM set QUANTITY_PICKED=? where ID=? and ful_ord_id=? and ITEM_ID=?";
        int update = jt.update(SQL, quantityPicked, id, fulFilmentId, itemId);
        if (update > 0) {

        } else {
            throw new PickUpdateException(ErrorMessages.LINE_ITEM_DOES_NOT_EXIST.getErrorMessage());
        }
    }

    private void fulPickOrdLineItem(Double quantityPicked, Long id, String itemId, Long pickId, Long fulFilmentId) {
        String SQL = "UPDATE SIM14.FUL_ORD_PICK_LINE_ITEM set QUANTITY_PICKED=? where ID=? and ITEM_ID=? and FUL_ORD_PICK_ID=? and FUL_ORD_ID=?";
        int update = jt.update(SQL, quantityPicked, id, itemId, pickId, fulFilmentId);
        if (update > 0) {
            // Picked Quantity Updated
        } else {
            throw new PickUpdateException(ErrorMessages.LINE_ITEM_DOES_NOT_EXIST.getErrorMessage());
        }
    }


}
