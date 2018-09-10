package com.intellitection_llc.shop.servlet;


import com.google.gson.Gson;
import com.intellitection_llc.shop.controller.ControllerFactory;
import com.intellitection_llc.shop.controller.custom.ItemController;
import com.intellitection_llc.shop.dto.ItemsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/search-items")
public class Search_Item_servlet extends HttpServlet {


    private ItemController itemController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            try {
                itemController = (ItemController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerType.ITEMS);

                String itemname = req.getParameter("cmbItemname");
//
                ItemsDTO itemsDTO = itemController.searchItemsname(itemname);

                String itemcode = itemsDTO.getItemcode();
                String unit = itemsDTO.getUnit();
                String unitprice = itemsDTO.getUnitprice();

                if (unit != null) {
                    out.print(itemcode + "+" + unit + "+" + unitprice);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
