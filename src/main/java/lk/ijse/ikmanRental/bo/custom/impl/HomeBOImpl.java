package lk.ijse.ikmanRental.bo.custom.impl;

import lk.ijse.ikmanRental.bo.custom.HomeBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.*;
import lk.ijse.ikmanRental.db.DBConnection;
import lk.ijse.ikmanRental.dto.VehicleInDTO;
import lk.ijse.ikmanRental.dto.VehicleOutDTO;
import lk.ijse.ikmanRental.entity.VehicleIn;
import lk.ijse.ikmanRental.entity.VehicleOut;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeBOImpl implements HomeBO {

    private final VehicleInDAO vehicleInDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEIN);
    private final CustomerDAO customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private final VehicleDAO vehicleDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLE);
    private final BookingDAO bookingDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKING);
    private final DriverDAO driverDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVER);
    private final BookingDetailDAO detailDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKINGDETAIL);
    private final DriverScheduleDAO driverScheduleDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVERSCHEDULE);
    private final DriverPaymentDAO paymentDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVERPAYMENT);
    private final VehicleOutDAO vehicleOutDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VEHICLEOUT);

    @Override
    public List<VehicleInDTO> getAllVehicleIn() throws SQLException {
        List<VehicleInDTO> vehicleInDTOS=new ArrayList<>();
        List<VehicleIn> vehicleIns=vehicleInDAO.getAll();
        for (VehicleIn in : vehicleIns){
            vehicleInDTOS.add(new VehicleInDTO(in.getVehicleNumber(),in.getDriverNic(),in.getDate(),in.getBookingId()));
        }
        return vehicleInDTOS;
    }

    @Override
    public int countCustomer() throws SQLException {
        return customerDAO.countCustomer();
    }

    @Override
    public int countVehicle() throws SQLException {
        return vehicleDAO.count();
    }

    @Override
    public int countBookings() throws SQLException {
        return bookingDAO.count();
    }

    @Override
    public int countDriver() throws SQLException {
        return driverDAO.count();
    }

    @Override
    public int countRidesFromBooking() throws SQLException {
        return bookingDAO.countRides();
    }

    @Override
    public List<String> getPendinngIdsFromBooking() throws SQLException {
        return bookingDAO.getPendinngIds();
    }

    @Override
    public List<String> getRunningIdsFromBooking() throws SQLException {
        return bookingDAO.getRunningIds();
    }

    @Override
    public String getVehicleNUmberInRunning(String id) throws SQLException {
        return detailDAO.getVehicleNUmberInRunning(id);
    }

    @Override
    public String getDriverNicInRunning(String id) throws SQLException {
        return driverScheduleDAO.getDriverNicInRunning(id);
    }

    @Override
    public boolean saveVehicleIn(VehicleInDTO vehicleIn, String id, String vehiclenumber, String available, String driverId) throws SQLException {
        Connection connection=null;

        try {
            connection= DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            if (!vehicleInDAO.save(new VehicleIn(
                    vehicleIn.getVehicleNumber(),
                    vehicleIn.getDriverNic(),
                    vehicleIn.getDate(),
                    vehicleIn.getBookingId()
            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            if (!bookingDAO.setStatus(id)){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!vehicleDAO.updateAvailabilityRunning(vehiclenumber,available)){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!paymentDAO.updatePayment(driverId)){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public Double getDistanceFromBooking(String id) throws SQLException {
        return bookingDAO.getDistance(id);
    }

    @Override
    public boolean saveVehicleOut(VehicleOutDTO vehicle, String id, String vehicleNumber, String running) throws SQLException {
        Connection connection=null;

        try {
            connection=DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            if (!vehicleOutDAO.save(new VehicleOut(
                    vehicle.getVehicleNumber(),
                    vehicle.getDriverNic(),
                    vehicle.getDistance(),
                    vehicle.getBookingId()
            ))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            if (!bookingDAO.updateVehicleOutFromBooking(id)){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
            if (!vehicleDAO.updateAvailabilityRunning(vehicleNumber,running)){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            connection.setAutoCommit(true);
        }

    }
}
