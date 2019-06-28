package com.sustc.data.model;

public class Member{
    private String epc;
    private String rawHex;
    private String rawDecimal;
    public Member(){}
    public Member(String epc, String rawHex, String rawDecimal){
        this.epc = epc;
        this.rawHex = rawHex;
        this.rawDecimal = rawDecimal;
    }
    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getRawHex() {
        return rawHex;
    }

    public void setRawHex(String rawHex) {
        this.rawHex = rawHex;
    }

    public String getRawDecimal() {
        return rawDecimal;
    }

    public void setRawDecimal(String rawDecimal) {
        this.rawDecimal = rawDecimal;
    }
}
