package com.example.fawazyr.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table ("winner")
public class Winner {
    @Id
    private Long idW;// autogenerated
    private String msisdn;
    private LocalDate date;
    private Integer giftId;


    public Winner (){

    }
    public Winner(String msisdn, LocalDate now, Integer giftId) {

        this.msisdn = msisdn;
        this.date = now;
        this.giftId = giftId;
    }

    public Winner(Long id, String msisdn, LocalDate date, Integer giftId) {
        this.idW = idW;
        this.msisdn = msisdn;
        this.date = date;
        this.giftId = giftId;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public Long getIdW() {
        return idW;
    }

    public void setIdW(Long idW) {
        this.idW = idW;
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
