package com.Polycake.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Voucher {
    private int voucherId;
    private String voucherCode;
    private BigDecimal discountValue;
    private Timestamp expiryDate;
    private BigDecimal minOrderValue;

    public Voucher() {
    }

    public Voucher(int voucherId, String voucherCode, BigDecimal discountValue, Timestamp expiryDate, BigDecimal minOrderValue) {
        this.voucherId = voucherId;
        this.voucherCode = voucherCode;
        this.discountValue = discountValue;
        this.expiryDate = expiryDate;
        this.minOrderValue = minOrderValue;
    }

    public int getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(int voucherId) {
        this.voucherId = voucherId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public BigDecimal getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(BigDecimal minOrderValue) {
        this.minOrderValue = minOrderValue;
    }
}