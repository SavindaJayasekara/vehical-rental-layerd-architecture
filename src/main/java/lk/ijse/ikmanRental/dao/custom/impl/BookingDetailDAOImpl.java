package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.BookingDAO;
import lk.ijse.ikmanRental.entity.*;

import java.sql.SQLException;
import java.util.List;

public class BookingDetailDAOImpl implements BookingDAO {
    @Override
    public boolean save(Booking dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Booking dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<Booking> getAll() throws SQLException {
        return null;
    }

    @Override
    public Booking getIdes(String s) throws SQLException {
        return null;
    }

    @Override
    public String getNextBookingID() throws SQLException {
        return null;
    }

    @Override
    public String splitOrderId(String currentId) {
        return null;
    }

    @Override
    public boolean addBooking(Booking booking, Bill bill, DriverPayment driverPay, DriverSchedule driverSchedule, BookingDetail bookingDetail) throws SQLException {
        return false;
    }

    @Override
    public List<String> getBookingIds() throws SQLException {
        return null;
    }

    @Override
    public boolean deleteBooking(String id) throws SQLException {
        return false;
    }

//    @Override
//    public boolean update(Booking booking, Bill bill, DriverPayment driverPay, DriverSchedule driverSchedule, BookingDetail bookingDetail) throws SQLException {
//        return false;
//    }

    @Override
    public List<String> getRunningIds() throws SQLException {
        return null;
    }

    @Override
    public boolean setStatus(String id) throws SQLException {
        return false;
    }

    @Override
    public List<String> getPendinngIds() throws SQLException {
        return null;
    }

    @Override
    public Double getDistance(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean updateVehicleOut(String id) throws SQLException {
        return false;
    }

    @Override
    public int count() throws SQLException {
        return 0;
    }

    @Override
    public int countRides() throws SQLException {
        return 0;
    }
}
