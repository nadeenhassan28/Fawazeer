package com.example.fawazyr.data;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PrizeHistoryRepository extends CrudRepository<PrizeHistory, String> {
    // custom query
    @Modifying
    @Query("UPDATE prizeHistory SET capacity = capacity + 1 ")
    int incrementCapacity();
    @Query("SELECT capacity FROM prizehistory  WHERE gift_id = :giftId")
    int countByGiftId(@Param("giftId") Integer giftId);




}
