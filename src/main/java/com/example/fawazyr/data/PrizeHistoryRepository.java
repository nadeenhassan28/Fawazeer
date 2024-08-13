package com.example.fawazyr.data;

import org.springframework.data.repository.CrudRepository;

public interface PrizeHistoryRepository extends CrudRepository<PrizeHistory, String> {
    // custom query
}
