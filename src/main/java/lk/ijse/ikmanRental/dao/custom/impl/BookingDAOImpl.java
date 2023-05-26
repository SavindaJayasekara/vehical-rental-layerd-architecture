package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.BookingDAO;
import lk.ijse.ikmanRental.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO{
    @Override
    public boolean save(Booking entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Booking entity) throws SQLException {
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
        ResultSet resultSet=SQLUtil.execute("SELECT BookingID FROM booking ORDER BY BookingID DESC LIMIT 1");
        if (resultSet.next()){
            return splitOrderId(resultSet.getString(1));
        }
        return null;
    }

    @Override
    public String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("O0");
            int id = Integer.parseInt(strings[0]);
            id++;
            return "00" + id;
        }
        return "001";
    }

    @Override
    public boolean addBooking(Booking booking, Bill bill, DriverPayment driverPay, DriverSchedule driverSchedule, BookingDetail bookingDetail) throws SQLException {
        return false;
    }

    @Override
    public List<String> getBookingIds() throws SQLException {
        List<String> bookingiDs=new ArrayList<>();
        ResultSet resultSet=SQLUtil.execute("SELECT BookingID FROM booking");
        while (resultSet.next()){
            bookingiDs.add(resultSet.getString(1));
        }
        return bookingiDs;
    }

    @Override
    public boolean deleteBooking(String id) throws SQLException {
        return false;
    }

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
