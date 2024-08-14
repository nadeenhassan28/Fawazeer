package com.example.fawazyr.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WinnerRepository extends CrudRepository<Winner, String> {

    @Query("SELECT * FROM winner WHERE msisdn = :msisdn ORDER BY date DESC LIMIT 1")
    Optional<Winner> findLatestByMsisdn(String msisdn);
}
