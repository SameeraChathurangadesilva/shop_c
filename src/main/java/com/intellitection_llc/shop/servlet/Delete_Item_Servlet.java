package com.intellitection_llc.shop.servlet;

import com.intellitection_llc.shop.controller.ControllerFactory;
import com.intellitection_llc.shop.controller.custom.ItemController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Delete_Item_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(PrintWriter out = resp.getWriter()) {
            ItemController itemController = (ItemController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerType.ITEMS);
            String customerName=req.getParameter("customerName");

            //Remove Customer using customerName
            boolean isDeleted=itemController.delete(customerName);
            if(isDeleted){
                out.print("customer remove success");
            }else{
                out.print("customer remove failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
