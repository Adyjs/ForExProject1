package com.foreignexproject;

public class RateBean
{
    private String currency , buyIn , soldOut ;

    public RateBean(String currency , String buyIn , String soldOut)
    {
        setCurrency(currency);
        setBuyIn(buyIn);
        setSoldOut(soldOut);
    }



    public void setCurrency(String currency)
    {
        this.currency=currency;
    }
    public String getCurrency()
    {
        return currency;
    }

    public void setBuyIn(String buyIn)
    {
        this.buyIn=buyIn;
    }
    public String getBuyIn()
    {
        return buyIn;
    }

    public void setSoldOut(String soldOut)
    {
        this.soldOut=soldOut;
    }
    public String getSoldOut()
    {
        return soldOut;
    }
}
