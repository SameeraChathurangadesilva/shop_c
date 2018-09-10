package com.intellitection_llc.shop.controller.custom.impl;

import com.intellitection_llc.shop.controller.custom.EstimateController;
import com.intellitection_llc.shop.controller.custom.ItemController;
import com.intellitection_llc.shop.dao.DAOFactory;
import com.intellitection_llc.shop.dao.custom.EstimateDAO;
import com.intellitection_llc.shop.dao.custom.EstimateDetailsDAO;
import com.intellitection_llc.shop.dao.custom.ItemDAO;
import com.intellitection_llc.shop.db.DBConnection;
import com.intellitection_llc.shop.dto.EstimateDTO;
import com.intellitection_llc.shop.dto.EstimateDetailsDTO;
import com.intellitection_llc.shop.dto.ItemsDTO;
import com.intellitection_llc.shop.dto.ViewAllEstimateDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstimateControllerImpl implements EstimateController {

    private EstimateDAO estimateDAO;
    private EstimateDetailsDAO estimateDetailsDAO;
    private ItemDAO itemDAO;
    private Connection connection;

    public EstimateControllerImpl() throws SQLException, ClassNotFoundException {
        estimateDAO = (EstimateDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ESTIMATE);
        estimateDetailsDAO = (EstimateDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ESTIMATEDETAILS);
        itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEMS);
        connection = DBConnection.getDBConnection();
    }

    @Override
    public ArrayList<ViewAllEstimateDTO> getAllEstimates() throws Exception {
        return estimateDAO.getAllEstimates();
    }

    @Override
    public boolean saveE(EstimateDTO estimateDTO) throws Exception {

        connection.setAutoCommit(false);

        try {
            boolean result = estimateDAO.add(new EstimateDTO(estimateDTO.getEstimateid(), estimateDTO.getEstimateid()));

            if (!result) {
                return false;
            }

            for (EstimateDetailsDTO estimateDetailsDTO : estimateDTO.getEstimateDetailsDTOS()) {

                result = estimateDetailsDAO.add(new EstimateDetailsDTO(estimateDetailsDTO.getEstimateid(), estimateDetailsDTO.getItemcode(), estimateDetailsDTO.getQty()));

                if (!result) {
                    connection.rollback();
                    return false;
                }
            }
            connection.commit();
            return true;
        } finally {
            connection.setAutoCommit(true);
        }
    }



    @Override
    public boolean add(EstimateDTO dto) throws Exception {

        boolean result = estimateDAO.add(dto);
        return result;
    }

    @Override
    public boolean update(EstimateDTO dto) throws Exception {

        boolean result = estimateDAO.update(dto);
        return result;
    }

    @Override
    public EstimateDTO search(String key) throws Exception {
        return null;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return false;
    }

    @Override
    public ArrayList<EstimateDTO> getAll() throws Exception {
        return estimateDAO.getAll();
    }
}
