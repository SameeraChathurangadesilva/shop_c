package com.intellitection_llc.shop.dao;

import com.intellitection_llc.shop.dao.custom.impl.EstimateDAOImpl;
import com.intellitection_llc.shop.dao.custom.impl.EstimateDetailsDAOImpl;
import com.intellitection_llc.shop.dao.custom.impl.ItemDAOImpl;

import java.sql.SQLException;

public class DAOFactory {


    public enum DAOTypes {
        ITEMS,ESTIMATE,ESTIMATEDETAILS;
    }

    public static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }

        return daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) throws SQLException, ClassNotFoundException {
        switch (types) {
            case ITEMS:
                return new ItemDAOImpl();
            case ESTIMATE:
                return new EstimateDAOImpl();
            case ESTIMATEDETAILS:
                return new EstimateDetailsDAOImpl();
            default:
                return null;

        }
    }
}
