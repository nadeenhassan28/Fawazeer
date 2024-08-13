package com.example.fawazyr.data;

public class Gifts {
    private Integer giftId;
    private Integer quantity;

    public Gifts() {
    }

    public Gifts(Integer giftId, Integer quantity) {
        this.giftId = giftId;
        this.quantity = quantity;
    }

    public Integer getGiftId() {
        return giftId;
    }

    public void setGiftId(Integer giftId) {
        this.giftId = giftId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
