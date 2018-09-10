package com.intellitection_llc.shop.dao.custom.impl;

import com.intellitection_llc.shop.dao.custom.ItemDAO;
import com.intellitection_llc.shop.db.DBConnection;
import com.intellitection_llc.shop.dto.ItemsDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {


    private Connection connection;

    public ItemDAOImpl() throws SQLException {
        connection = DBConnection.getDBConnection();
    }

    public boolean add(ItemsDTO dto) throws Exception {

        String SQL = "INSERT INTO Items VALUES (?,?,?,?)";

        PreparedStatement pstm = connection.prepareStatement(SQL);

        pstm.setObject(1, dto.getItemcode());
        pstm.setObject(2, dto.getItemname());
        pstm.setObject(3, dto.getUnit());
        pstm.setObject(4,dto.getUnitprice());

        int result = pstm.executeUpdate();

        return (result > 0);
    }

    public boolean update(ItemsDTO dto) throws Exception {

        String SQL = "UPDATE Items SET itemname =?,unit=?,unitprice=? WHERE itemcode=?";

        PreparedStatement pstm = connection.prepareStatement(SQL);

        pstm.setObject(1, dto.getItemname());
        pstm.setObject(2, dto.getUnit());
        pstm.setObject(3, dto.getUnitprice());
        pstm.setObject(4, dto.getItemcode());

        int result = pstm.executeUpdate();
        return (result > 0);
    }

    public ItemsDTO search(String key) throws Exception {

        String sql = "SELETE * FROM Items WHERE itemcode ='" + key + "' ";

        ItemsDTO itemsDTO = null;

        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {

            itemsDTO = new ItemsDTO(
                    rst.getString("itemcode"),
                    rst.getString("itemname"),
                    rst.getString("unit"),
                    rst.getString("unitprice"));
        }
        return itemsDTO;

    }

    public boolean delete(String key) throws Exception {

        String sql = "DELETE FROM Items WHERE itemcode='"+key+"'";

        Statement stm = connection.createStatement();
        int affectedRows = stm.executeUpdate(sql);

        return (affectedRows > 0);
    }

    public ArrayList<ItemsDTO> getAll() throws Exception {
        String sql = "SELECT * FROM Items";

        ArrayList<ItemsDTO> allItems = null;

        Statement stm = connection.createStatement();
        ResultSet rstm = stm.executeQuery(sql);

        while (rstm.next()){

            if(allItems== null){
                allItems = new ArrayList<>();
            }

            ItemsDTO itemsDTO = new ItemsDTO(
                    rstm.getString("itemcode"),
                    rstm.getString("itemname"),
                    rstm.getString("unit"),
                    rstm.getString("unitprice")
            );

            allItems.add(itemsDTO);
        }
        return allItems;
    }

    @Override
    public ItemsDTO searchItemsname(String itemname) throws SQLException {


        String SQL = "SELECT * FROM Items WHERE itemname='" + itemname + "'";

        ItemsDTO itemsDTO = null;

        Statement stm = connection.createStatement();
        ResultSet rstm = stm.executeQuery(SQL);
        if (rstm.next()) {

            ItemsDTO items = new ItemsDTO();
            items.setItemcode(rstm.getString(1));
            items.setItemname(rstm.getString(2));
            items.setUnit(rstm.getString(3));
            items.setUnitprice(rstm.getString(4));
            return items;

        }
        return null;
    }
}
