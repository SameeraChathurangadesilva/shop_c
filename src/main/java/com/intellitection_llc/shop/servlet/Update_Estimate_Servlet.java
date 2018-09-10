package com.intellitection_llc.shop.servlet;

import com.intellitection_llc.shop.db.DBConnection;

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


@WebServlet(urlPatterns = "/UpdateEstimate")
public class Update_Estimate_Servlet extends HttpServlet {

    private Connection connection;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String estimateid = req.getParameter("txtEstimateid");
        String status = req.getParameter("txtStatus");
        String itemcode = req.getParameter("txtItemcode");
        String qty  = req.getParameter("txtUnit");

        System.out.println(estimateid+"eeee");

        boolean done = false;
        try {
            connection = DBConnection.getDBConnection();


            PreparedStatement pstm1 = connection.prepareStatement("UPDATE Estimate SET status =? WHERE estimateid=?");

            pstm1.setObject(1, status);
            pstm1.setObject(2, estimateid);

            boolean res1 = pstm1.executeUpdate() > 0;

            PreparedStatement pstm2 = connection.prepareStatement("UPDATE EstimateDetails SET itemcode =?,qty=? WHERE estimateid=?");

            pstm2.setObject(1, itemcode);
            pstm2.setObject(2, qty);
            pstm2.setObject(3, estimateid);
            boolean res2 = pstm2.executeUpdate() > 0;

            connection.setAutoCommit(false);

            if (res1 && res2) {
                connection.commit();
                done = true;

                System.out.println(done);
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html");
        try (PrintWriter out = resp.getWriter()) {

            if (done) {

                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manage_Estimate.jsp");
                requestDispatcher.include(req,resp);


            } else {

                resp.sendRedirect(req.getContextPath() + "/Manage_Estimate.jsp");
            }
        }
    }
}
