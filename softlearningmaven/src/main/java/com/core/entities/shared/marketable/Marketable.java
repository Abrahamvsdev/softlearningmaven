package com.core.entities.shared.marketable;

public interface Marketable {
    boolean getDelayPay();
    double getDiscount();
    String getType();
    String getPayMethod();
}