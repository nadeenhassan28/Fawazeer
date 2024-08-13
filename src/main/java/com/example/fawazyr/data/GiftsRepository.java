package com.example.fawazyr.data;

import org.springframework.data.repository.CrudRepository;

public interface GiftsRepository extends CrudRepository<Gifts, Integer> {
    //custom query
}
