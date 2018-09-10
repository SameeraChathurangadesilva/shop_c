package com.intellitection_llc.shop.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class EstimateDTO extends SuperDTO implements Serializable {

    private String estimateid;
    private String status;
    private ArrayList<EstimateDetailsDTO> estimateDetailsDTOS;


    public EstimateDTO() {
    }

    public EstimateDTO(String estimateid, String status) {
        this.estimateid = estimateid;
        this.status = status;
    }

    public EstimateDTO(String estimateid, String status, ArrayList<EstimateDetailsDTO> estimateDetailsDTOS) {
        this.estimateid = estimateid;
        this.status = status;
        this.estimateDetailsDTOS = estimateDetailsDTOS;
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

    public ArrayList<EstimateDetailsDTO> getEstimateDetailsDTOS() {
        return estimateDetailsDTOS;
    }

    public void setEstimateDetailsDTOS(ArrayList<EstimateDetailsDTO> estimateDetailsDTOS) {
        this.estimateDetailsDTOS = estimateDetailsDTOS;
    }

    @Override
    public String toString() {
        return "EstimateDTO{" +
                "estimateid='" + estimateid + '\'' +
                ", status='" + status + '\'' +
                ", estimateDetailsDTOS=" + estimateDetailsDTOS +
                '}';
    }
}
