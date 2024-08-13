package com.example.fawazyr.data;

import org.springframework.data.repository.CrudRepository;

public interface WinnerRepository extends CrudRepository<Winner, String> {
    //custom query
}
