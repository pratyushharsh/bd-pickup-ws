package com.snumbers.pickupws.repository;

import com.snumbers.pickupws.entity.FulOrdLineItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FulOrdLineItemRepositry extends CrudRepository<FulOrdLineItemEntity, Long> {

}
