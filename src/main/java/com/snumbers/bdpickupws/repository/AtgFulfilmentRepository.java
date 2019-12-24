package com.snumbers.bdpickupws.repository;

import com.snumbers.bdpickupws.entity.AtgFulOrdPickAssignEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtgFulfilmentRepository extends CrudRepository<AtgFulOrdPickAssignEntity, Long> {

    @Query(value = "select * from SIM14.ATG_FUL_ORD_PICK_ASSIGN where pick_user_id = ?1", nativeQuery = true)
    List<AtgFulOrdPickAssignEntity> findAllByPickUser(String username);

    @Query(value = "select * from SIM14.ATG_FUL_ORD_PICK_ASSIGN where pick_user_id = :pickUser and pick_id = :pickId", nativeQuery = true)
    AtgFulOrdPickAssignEntity findByPick_UserAndPick_Id(String pickUser, Long pickId);
}
