package com.example.fawazyr.data;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WinnerRepository extends CrudRepository<Winner, String> {

    @Query("\n" +
            "SELECT * \n" +
            "FROM winner \n" +
            "WHERE msisdn = :msisdn \n" +
            "ORDER BY date DESC \n" +
            "LIMIT 1;")
    Optional<Winner> findLatestByMsisdn(String msisdn);
}
