package lk.ijse.ikmanRental.dao;

import lk.ijse.ikmanRental.dao.custom.impl.*;

public class DAOFactory implements SuperDAO {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return daoFactory == null ? new DAOFactory() : daoFactory;
    }

   public enum DAOTypes {
        ADMIN,BILL,BOOKING,BOOKINGDETAIL,CUSTOMER,DRIVER,DRIVERPAYMENT,DRIVERSCHEDULE,VEHICLE,VEHICLEIN,VEHICLEOUT

    }

    public <T extends SuperDAO>T getDAO(DAOTypes types) {
        switch (types) {
            case ADMIN:
                return (T) new AdminDAOImpl();
            case BILL:
                return (T) new BillDAOImpl();
            case BOOKING:
                return (T) new BookingDAOImpl();
            case BOOKINGDETAIL:
                return (T) new BookingDetailDAOImpl();
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case DRIVER:
                return (T) new DriverDAOImpl();
            case DRIVERPAYMENT:
                return (T) new DriverPaymentDAOImpl();
            case DRIVERSCHEDULE:
                return (T) new DriverScheduleDAOImpl();
            case VEHICLE:
                return (T) new VehicleDAOImpl();
            case VEHICLEIN:
                return (T) new VehicleInDAOImpl();
            case VEHICLEOUT:
                return (T) new VehicleOutDAOImpl();
            default:
                return null;
        }
    }
}
