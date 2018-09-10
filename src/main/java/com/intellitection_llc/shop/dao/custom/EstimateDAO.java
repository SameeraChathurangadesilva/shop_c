package com.intellitection_llc.shop.dao.custom;

import com.intellitection_llc.shop.dao.SuperDAO;
import com.intellitection_llc.shop.dto.EstimateDTO;
import com.intellitection_llc.shop.dto.EstimateDetailsDTO;
import com.intellitection_llc.shop.dto.ViewAllEstimateDTO;

import java.util.ArrayList;

public interface EstimateDAO extends SuperDAO<EstimateDTO> {

    public ArrayList<ViewAllEstimateDTO> getAllEstimates()throws Exception;

//    public boolean save(ArrayList<EstimateDTO>estimateDTOS) throws Exception;
//
//    public boolean updateEstimate(ArrayList<EstimateDTO>estimateDTOS)throws Exception;

}
