package com.example.fawazyr.data;

import java.time.LocalDate;

public class PrizeHistory {
    private Integer capacity;
    private String msisdn;
    private Integer giftId;
    private LocalDate date;

    public PrizeHistory() {
    }

    public PrizeHistory(Integer capacity, String msisdn, Integer giftId, LocalDate date) {
        this.capacity = capacity;
        this.msisdn = msisdn;
        this.giftId = giftId;
        this.date = date;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
