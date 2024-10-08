package com.example.fawazyr.data;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public interface PrizeHistoryRepository extends CrudRepository<PrizeHistory, String> {
    // custom query
    @Modifying
    @Query("UPDATE prizeHistory SET capacity = capacity + 1 WHERE msisdn= :msisdn")
    int incrementCapacity(@Param("msisdn") String msisdn);
    @Query("SELECT capacity FROM prizehistory  WHERE gift_id = :giftId LIMIT 1")
    Optional<Number> countByGiftId(@Param("giftId") Integer giftId);


    @Query(value = "SELECT date FROM prizeHistory ORDER BY date DESC LIMIT 1")
    LocalDate latestEntryPrizeHistory();

    @Modifying
    @Query(value = "TRUNCATE TABLE prizeHistory")
    void deletePrizeHistoryQuery();


}
