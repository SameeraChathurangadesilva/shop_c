package com.intellitection_llc.shop.controller.custom.impl;

import com.intellitection_llc.shop.controller.custom.EstimateDetailsController;
import com.intellitection_llc.shop.dao.DAOFactory;
import com.intellitection_llc.shop.dao.custom.EstimateDAO;
import com.intellitection_llc.shop.dao.custom.EstimateDetailsDAO;
import com.intellitection_llc.shop.dto.EstimateDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EstimateDetailsControllerImpl implements EstimateDetailsController {

    private EstimateDetailsDAO estimateDetailsDAO;

    public EstimateDetailsControllerImpl() throws SQLException, ClassNotFoundException {
        estimateDetailsDAO = (EstimateDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ESTIMATEDETAILS);
    }

    @Override
    public boolean add(EstimateDetailsDTO dto) throws Exception {

        boolean result = estimateDetailsDAO.add(dto);
        return result;
    }

    @Override
    public boolean update(EstimateDetailsDTO dto) throws Exception {

        boolean result = estimateDetailsDAO.update(dto);
        return result;
    }

    @Override
    public EstimateDetailsDTO search(String key) throws Exception {
        return null;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public ArrayList<EstimateDetailsDTO> getAll() throws Exception {
        return null;
    }
}
