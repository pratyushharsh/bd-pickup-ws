package com.snumbers.pickupws.repository;

import com.snumbers.pickupws.entity.PickLineItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PickOrderDetailRepository extends CrudRepository<PickLineItemEntity, Long> {

    @Query(value = "select * from sim14.ful_ord_pick_line_item p where p.ful_ord_pick_id = ?1", nativeQuery = true)
    List<PickLineItemEntity> findallbyfulOrdPickId(long pickId);
}
