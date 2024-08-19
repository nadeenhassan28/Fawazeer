package com.example.fawazyr.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Table(name = "prizehistory")
public record PrizeHistory (

        @Id      Long id,// autogenerated
                 Integer capacity,
                 String msisdn,
                 Integer giftId,
                 LocalDate date


){


//    public PrizeHistory(int i, String msisdn, Integer giftId, LocalDate now) {
//    }
//
//    public PrizeHistory(Long id, Integer capacity, String msisdn, Integer giftId, LocalDate date) {
//        this.id = id;
//        this.capacity = capacity;
//        this.msisdn = msisdn;
//        this.giftId = giftId;
//        this.date = date;
//    }
//
//    public PrizeHistory(String msisdn, Integer giftId, LocalDate now) {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Integer getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(Integer capacity) {
//        this.capacity = capacity;
//    }
//
//    public String getMsisdn() {
//        return msisdn;
//    }
//
//    public void setMsisdn(String msisdn) {
//        this.msisdn = msisdn;
//    }
//
//    public Integer getGiftId() {
//        return giftId;
//    }
//
//    public void setGiftId(Integer giftId) {
//        this.giftId = giftId;
//    }
//
//    public LocalDate getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDate date) {
//        this.date = date;
//    }

}
