package com.intellitection_llc.shop.dto;

import java.io.Serializable;

public class EstimateDetailsDTO extends SuperDTO implements Serializable {

    private String estimateid;
    private String itemcode;
    private String qty;

    public EstimateDetailsDTO() {
    }

    public EstimateDetailsDTO(String estimateid, String itemcode, String qty) {
        this.estimateid = estimateid;
        this.itemcode = itemcode;
        this.qty = qty;
    }

    public String getEstimateid() {
        return estimateid;
    }

    public void setEstimateid(String estimateid) {
        this.estimateid = estimateid;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "EstimateDetailsDTO{" +
                "estimateid='" + estimateid + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
