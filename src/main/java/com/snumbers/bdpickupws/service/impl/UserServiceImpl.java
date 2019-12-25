package com.snumbers.bdpickupws.service.impl;

import com.snumbers.bdpickupws.service.UserService;
import com.snumbers.bdpickupws.shared.dto.UserDashBoardDto;
import com.snumbers.bdpickupws.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDashBoardDto getUserDashBoard(String userId) {
        // Prep work
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        SQLQuery query = session.createSQLQuery("Select * from (\n" +
                "    Select pick_user_id, status from sim14.atg_ful_ord_pick_assign) \n" +
                "    PIVOT (COUNT(status) as status for (status) IN (0 as NEW, 1 as IN_PROGRESS, 2 as COMPLETED, 3 as CANCELLED, 4 as ACTIVE)\n" +
                ") where pick_user_id = '" + userId + "'");
        List<Object[]> rows = query.list();
        tx.commit();
        UserDashBoardDto user = new UserDashBoardDto();
        user.setUserId(userId);
        if (rows.size() > 0) {
            Object[] row = rows.get(0);
            user.setNewOrder(Long.parseLong(row[1].toString()));
            user.setInProgressOrder(Long.parseLong(row[2].toString()));
            user.setCompletedOrder(Long.parseLong(row[3].toString()));
            user.setCancelledOrder(Long.parseLong(row[4].toString()));
            user.setActiveOrders(Long.parseLong(row[5].toString()));
        }
        return user;
    }
}
