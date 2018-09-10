package com.intellitection_llc.shop.controller.custom;

import com.intellitection_llc.shop.controller.SuperController;
import com.intellitection_llc.shop.dao.SuperDAO;
import com.intellitection_llc.shop.dto.ItemsDTO;

import java.sql.SQLException;

public interface ItemController extends SuperController<ItemsDTO> {

    public ItemsDTO searchItemsname(String itemname) throws SQLException;


}
