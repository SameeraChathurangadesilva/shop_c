package com.intellitection_llc.shop.controller.custom;

import com.intellitection_llc.shop.controller.SuperController;
import com.intellitection_llc.shop.dto.EstimateDTO;
import com.intellitection_llc.shop.dto.ViewAllEstimateDTO;

import java.util.ArrayList;

public interface EstimateController extends SuperController<EstimateDTO> {

    public ArrayList<ViewAllEstimateDTO> getAllEstimates()throws Exception;

    public boolean saveE(EstimateDTO estimateDTO)throws Exception;
}
