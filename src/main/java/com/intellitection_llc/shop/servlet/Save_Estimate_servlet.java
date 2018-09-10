package com.intellitection_llc.shop.servlet;

import com.intellitection_llc.shop.controller.ControllerFactory;
import com.intellitection_llc.shop.controller.custom.EstimateController;
import com.intellitection_llc.shop.controller.custom.EstimateDetailsController;
import com.intellitection_llc.shop.controller.custom.ItemController;
import com.intellitection_llc.shop.db.DBConnection;
import com.intellitection_llc.shop.dto.EstimateDetailsDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/AddEstimate")
public class Save_Estimate_servlet extends HttpServlet {

    private EstimateController estimateController;
    private EstimateDetailsController estimateDetailsController;
    private ItemController itemController;
    private Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String estimateid = req.getParameter("txtEstimateid");
        String status = req.getParameter("txtStatus");
        String itemcode = req.getParameter("txtItemcode");
        String qty  = req.getParameter("txtQty");

        ArrayList<EstimateDetailsDTO> estimateDetailsDTOS=new ArrayList<>();

        boolean done = false;

        try {

            connection = DBConnection.getDBConnection();
            connection.setAutoCommit(false);

            PreparedStatement pstm1 = connection.prepareStatement("INSERT INTO Estimate VALUES (?,?)");

            pstm1.setObject(1, estimateid);
            pstm1.setObject(2, status);

            boolean res1 = pstm1.executeUpdate() > 0;
            if(res1){
                PreparedStatement pstm2 = connection.prepareStatement("INSERT INTO EstimateDetails VALUES (?,?,?)");

                pstm2.setObject(1, estimateid);
                pstm2.setObject(2, itemcode);
                pstm2.setObject(3, qty);

                boolean res2 = pstm2.executeUpdate() > 0;

                if(res2){
                    connection.commit();
                    done = true;
                }
            }

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {

            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {

            if (done) {

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Create_Estimate.jsp");
                requestDispatcher.include(req,resp);


            } else {

                resp.sendRedirect(req.getContextPath() + "/Create_Estimate.jsp");
            }
        }

    }
}
