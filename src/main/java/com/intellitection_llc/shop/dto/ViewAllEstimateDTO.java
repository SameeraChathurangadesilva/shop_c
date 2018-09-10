package com.intellitection_llc.shop.dto;

public class ViewAllEstimateDTO {

    private String estimateid;
    private String status;
    private String itemcode;
    private String qty;

    public ViewAllEstimateDTO() {
    }

    public ViewAllEstimateDTO(String estimateid, String status, String itemcode, String qty) {
        this.estimateid = estimateid;
        this.status = status;
        this.itemcode = itemcode;
        this.qty = qty;
    }

    public String getEstimateid() {
        return estimateid;
    }

    public void setEstimateid(String estimateid) {
        this.estimateid = estimateid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        return "ViewAllEstimateDTO{" +
                "estimateid='" + estimateid + '\'' +
                ", status='" + status + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
