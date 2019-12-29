package com.snumbers.bdpickupws.repository;

import com.snumbers.bdpickupws.entity.FulOrdLineItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FulOrdLineItemRepositry extends CrudRepository<FulOrdLineItemEntity, Long> {

}
