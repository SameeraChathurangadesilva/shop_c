package com.intellitection_llc.shop.servlet;

import com.intellitection_llc.shop.controller.ControllerFactory;
import com.intellitection_llc.shop.controller.custom.ItemController;
import com.intellitection_llc.shop.dto.ItemsDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/updateItemForm")
public class Update_Item_servlet extends HttpServlet {


    private ItemController itemController;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            itemController = (ItemController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerType.ITEMS);


            String itemcode = req.getParameter("itemcode");
            String itemname = req.getParameter("itemname");
            String unit  = req.getParameter("unit");
            String unitprice = req.getParameter("unitprice");

            ItemsDTO itemsDTO = new ItemsDTO(itemcode,itemname,unit,unitprice);

            try {
                boolean result = itemController.update(itemsDTO);
                PrintWriter out= resp.getWriter();
                if (result){
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("Add_Items.jsp");
                    requestDispatcher.include(req,resp);

                }else {
                    resp.sendRedirect(req.getContextPath() + "/Add_Items.jsp");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
