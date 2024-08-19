package com.example.fawazyr.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PrizeHistoryRepository extends CrudRepository<PrizeHistory, String> {
    // custom query
    @Query("SELECT capacity FROM prizeHistory  WHERE gift_id = :giftId LIMIT 1")
    int countByGiftId(Integer giftId);



}
