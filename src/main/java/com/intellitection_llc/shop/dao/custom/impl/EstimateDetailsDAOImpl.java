package com.intellitection_llc.shop.dao.custom.impl;

import com.intellitection_llc.shop.dao.custom.EstimateDetailsDAO;
import com.intellitection_llc.shop.db.DBConnection;
import com.intellitection_llc.shop.dto.EstimateDTO;
import com.intellitection_llc.shop.dto.EstimateDetailsDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstimateDetailsDAOImpl implements EstimateDetailsDAO {


    private Connection connection;

    public EstimateDetailsDAOImpl() throws SQLException {
        connection = DBConnection.getDBConnection();
    }


    @Override
    public  boolean add(EstimateDetailsDTO dto) throws Exception {


        String SQL = "INSERT INTO EstimateDetails VALUES (?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(SQL);

        pstm.setObject(1, dto.getEstimateid());
        pstm.setObject(2, dto.getItemcode());
        pstm.setObject(3, dto.getQty());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(EstimateDetailsDTO dto) throws Exception {

        String SQL = "UPDATE EstimateDetails SET itemcode =?,qty=? WHERE estimateid=?";

        PreparedStatement pstm = connection.prepareStatement(SQL);

        pstm.setObject(1, dto.getItemcode());
        pstm.setObject(2, dto.getQty());
        pstm.setObject(3, dto.getEstimateid());

        int result = pstm.executeUpdate();
        return (result > 0);
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
//
//    @Override
//    public boolean saveEstimateDetails(ArrayList<EstimateDetailsDTO> estimateDetailsDTOS) throws Exception {
//
//        String sql = "INSERT INTO EstimateDetails VALUES(?,?,?)";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        for(EstimateDetailsDTO dto:estimateDetailsDTOS){
//            pstm.setString(1, dto.getEstimateid());
//            pstm.setString(2, dto.getItemcode());
//            pstm.setString(3, dto.getQty());
//        }
//        int result = pstm.executeUpdate();
//
//        return (result > 0);
//    }
}
