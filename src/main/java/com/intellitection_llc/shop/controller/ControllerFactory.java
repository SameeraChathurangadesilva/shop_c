package com.intellitection_llc.shop.controller;

import com.intellitection_llc.shop.controller.custom.impl.EstimateControllerImpl;
import com.intellitection_llc.shop.controller.custom.impl.EstimateDetailsControllerImpl;
import com.intellitection_llc.shop.controller.custom.impl.ItemControllerImpl;

import java.sql.SQLException;

public class ControllerFactory {


    public enum ControllerType {
        ITEMS,ESTIMATE,ESTIMATEDETAILS;
    }

    public static ControllerFactory controllerFactory;

    private ControllerFactory() {
    }

    public static ControllerFactory getInstance() {
        if (controllerFactory == null) {
            controllerFactory = new ControllerFactory();
        }
        return controllerFactory;
    }

    public SuperController getController(ControllerType controllerType) throws SQLException, ClassNotFoundException {
        switch (controllerType) {
            case ITEMS:
                return new ItemControllerImpl();
            case ESTIMATE:
                return new EstimateControllerImpl();
            case ESTIMATEDETAILS:
                return new EstimateDetailsControllerImpl();
            default:
                return null;
        }
    }
}
