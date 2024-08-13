package com.example.fawazyr.data;

import java.time.LocalDate;

public class Winner {
    private String msisdn;
    private LocalDate date;
    private Integer giftId;

    public Winner() {
    }

    public Winner(String msisdn, LocalDate date, Integer giftId) {
        this.msisdn = msisdn;
        this.date = date;
        this.giftId = giftId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

}
