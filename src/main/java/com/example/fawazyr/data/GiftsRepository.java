package com.example.fawazyr.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftsRepository extends CrudRepository<Gifts, Integer> {
    //custom query
    @Query("SELECT quantity FROM gifts WHERE g.giftId = :giftId")
    Integer findQuantityByGiftId(@Param("giftId") Integer giftId);
}
