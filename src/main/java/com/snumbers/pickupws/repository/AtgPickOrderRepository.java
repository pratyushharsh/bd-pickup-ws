package com.snumbers.pickupws.repository;

import com.snumbers.pickupws.entity.AtgPickOrderView;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AtgPickOrderRepository extends CrudRepository<AtgPickOrderView, Long> {

    List<AtgPickOrderView> findAllByPickUser(String user);

    List<AtgPickOrderView> findAllByPickUserAndOrderStatus(String pickuser, Long orderStatus);
}
