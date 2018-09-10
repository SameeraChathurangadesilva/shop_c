package com.intellitection_llc.shop.dao.custom.impl;

import com.intellitection_llc.shop.dao.custom.EstimateDAO;
import com.intellitection_llc.shop.db.DBConnection;
import com.intellitection_llc.shop.dto.EstimateDTO;
import com.intellitection_llc.shop.dto.ViewAllEstimateDTO;

import java.sql.*;
import java.util.ArrayList;

public class EstimateDAOImpl implements EstimateDAO {


    private Connection connection;

    public EstimateDAOImpl() throws SQLException {
        connection = DBConnection.getDBConnection();
    }

    @Override
    public  boolean add(EstimateDTO dto) throws Exception {

        String SQL = "INSERT INTO Estimate VALUES (?,?)";

        PreparedStatement pstm = connection.prepareStatement(SQL);

        pstm.setObject(1, dto.getEstimateid());
        pstm.setObject(2, dto.getStatus());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    @Override
    public boolean update(EstimateDTO dto) throws Exception {

        String SQL = "UPDATE Estimate SET status =? WHERE estimateid=?";

        PreparedStatement pstm = connection.prepareStatement(SQL);

        pstm.setObject(1, dto.getStatus());
        pstm.setObject(2, dto.getEstimateid());

        int result = pstm.executeUpdate();
        return (result > 0);

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

       return null;
    }

    @Override
    public ArrayList<ViewAllEstimateDTO> getAllEstimates() throws Exception {

        String sql = "select  e.estimateid,e.status,ed.itemcode,ed.qty from Estimate e,EstimateDetails ed where e.estimateid = ed.estimateid";

        ArrayList<ViewAllEstimateDTO> allEstimateDTOS = null;

        Statement stm = connection.createStatement();
        ResultSet rstm = stm.executeQuery(sql);

        System.out.println(rstm+"DAO");
        while (rstm.next()) {

            if (allEstimateDTOS == null) {
                allEstimateDTOS = new ArrayList<>();
            }

            ViewAllEstimateDTO viewAllEstimateDTO = new ViewAllEstimateDTO(
                    rstm.getString("estimateid"),
                    rstm.getString("status"),
                    rstm.getString("itemcode"),
                    rstm.getString("qty")
            );

            allEstimateDTOS.add(viewAllEstimateDTO);
        }
        return allEstimateDTOS;
    }

//    @Override
//    public boolean save(ArrayList<EstimateDTO> estimateDTOS) throws Exception {
//
//        String sql = "INSERT INTO Estimate VALUES(?,?)";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        for(EstimateDTO dto:estimateDTOS){
//            pstm.setString(1, dto.getEstimateid());
//            pstm.setString(2, dto.getStatus());
//        }
//        int result = pstm.executeUpdate();
//
//        return (result > 0);
//    }

}
