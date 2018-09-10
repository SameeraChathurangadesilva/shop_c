package com.intellitection_llc.shop.dao.custom;

import com.intellitection_llc.shop.dao.SuperDAO;
import com.intellitection_llc.shop.dto.ItemsDTO;

import java.sql.SQLException;

public interface ItemDAO extends SuperDAO<ItemsDTO> {

    public ItemsDTO searchItemsname(String itemname) throws SQLException;

}
