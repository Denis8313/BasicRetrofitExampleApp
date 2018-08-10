package com.example.denis.basicretrofitexampleapp;

import com.google.gson.annotations.SerializedName;

public class CurrencyData {

    @SerializedName("currency_code")
    private String currency;
    @SerializedName("unit_value")
    private int unitValue;
    @SerializedName("buying_rate")
    private double buyingRate;
    @SerializedName("median_rate")
    private double medianRate;
    @SerializedName("selling_rate")
    private double sellingRate;

    public CurrencyData(String currency, int unitValue, double buyingRate, double medianRate, double sellingRate) {
        this.currency = currency;
        this.unitValue = unitValue;
        this.buyingRate = buyingRate;
        this.medianRate = medianRate;
        this.sellingRate = sellingRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }

    public double getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(double buyingRate) {
        this.buyingRate = buyingRate;
    }

    public double getMedianRate() {
        return medianRate;
    }

    public void setMedianRate(double medianRate) {
        this.medianRate = medianRate;
    }

    public double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(double sellingRate) {
        this.sellingRate = sellingRate;
    }
}
