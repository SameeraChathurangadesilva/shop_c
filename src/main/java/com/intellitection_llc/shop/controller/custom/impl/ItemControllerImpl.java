package com.intellitection_llc.shop.controller.custom.impl;

import com.intellitection_llc.shop.controller.SuperController;
import com.intellitection_llc.shop.controller.custom.ItemController;
import com.intellitection_llc.shop.dao.DAOFactory;
import com.intellitection_llc.shop.dao.custom.ItemDAO;
import com.intellitection_llc.shop.dto.ItemsDTO;
import com.intellitection_llc.shop.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemControllerImpl implements ItemController {

    private ItemDAO itemDAO;

    public ItemControllerImpl() throws SQLException, ClassNotFoundException {
        itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEMS);
    }

    public boolean add(ItemsDTO dto) throws Exception {

        boolean result = itemDAO.add(dto);
        return result;
    }

    public boolean update(ItemsDTO dto) throws Exception {

        boolean result = itemDAO.update(dto);
        return result;
    }

    public ItemsDTO search(String key) throws Exception {
        return null;
    }

    public boolean delete(String key) throws Exception {
        return itemDAO.delete(key);
    }

    public ArrayList<ItemsDTO> getAll() throws Exception {
        return itemDAO.getAll();
    }

    @Override
    public ItemsDTO searchItemsname(String itemname) throws SQLException {
        return itemDAO.searchItemsname(itemname);
    }
}
