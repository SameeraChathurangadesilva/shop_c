package com.intellitection_llc.shop.dto;

import java.io.Serializable;

public class ItemsDTO extends SuperDTO implements Serializable {

    private String itemcode;
    private String itemname;
    private String unit;
    private String unitprice;

    public ItemsDTO() {
    }

    public ItemsDTO(String itemcode, String itemname, String unit, String unitprice) {
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.unit = unit;
        this.unitprice = unitprice;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }

}
