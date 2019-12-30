package com.snumbers.pickupws.service.impl;

import com.snumbers.pickupws.exception.OrderServiceException;
import com.snumbers.pickupws.service.UserService;
import com.snumbers.pickupws.shared.dto.UserDashBoardDto;
import com.snumbers.pickupws.ui.model.response.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jt;

    @Override
    @Transactional(readOnly = true)
    public UserDashBoardDto getUserDashBoard(String userId) {
        // handle no if user not present
        UserDashBoardDto res;
        try {
            res = jt.queryForObject("Select * from (" +
                    "    Select pick_user_id, status from sim14.atg_ful_ord_pick_assign) " +
                    "    PIVOT (COUNT(status) as status for (status) IN (0 as NEW, 1 as IN_PROGRESS, 2 as COMPLETED, 3 as CANCELLED, 4 as ACTIVE)" +
                    ") where pick_user_id = ?", new Object[]{userId}, (rs, rowNum) -> new UserDashBoardDto(
                    rs.getString("PICK_USER_ID"),
                    rs.getLong("NEW_STATUS"),
                    rs.getLong("IN_PROGRESS_STATUS"),
                    rs.getLong("COMPLETED_STATUS"),
                    rs.getLong("CANCELLED_STATUS"),
                    rs.getLong("ACTIVE_STATUS")
            ));
        } catch (EmptyResultDataAccessException e) {
            throw new OrderServiceException(ErrorMessages.USER_DOES_NOT_EXIST.getErrorMessage());
        }
        return res;
    }
}
