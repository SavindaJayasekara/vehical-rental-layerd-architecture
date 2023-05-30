package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.BookingDAO;
import lk.ijse.ikmanRental.entity.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO{
    @Override
    public boolean save(Booking entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO booking (BookingID,Status,AmmountCost,RequriedDate,RideTO,Distance,CustomerNIC)" +
                "VALUES(?, ?, ?, ?, ?, ?, ?)",entity.getBookingID(),entity.getStatus(),entity.getAmountsCost(),
                entity.getRequiredDate(),entity.getRideTo(),entity.getDistance(),
                entity.getCustomerNic());
    }

    @Override
    public boolean update(Booking entity) throws SQLException {
        return SQLUtil.execute("UPDATE booking SET Status=?, AmmountCost=? ,RequriedDate=? ,RideTO=? ,Distance=? ,CustomerNIC=? WHERE BookingID=?",entity.getStatus(),entity.getAmountsCost(),entity.getRequiredDate(),entity.getRideTo(),entity.getDistance(),entity.getCustomerNic(),entity.getBookingID());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return SQLUtil.execute("DELETE FROM booking WHERE BookingID = ?",s);
    }

    @Override
    public List<Booking> getAll() throws SQLException {
        List<Booking> bookings=new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM booking");
        while (resultSet.next()){
            bookings.add(new Booking(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            ));
        }
        return bookings;
    }

    @Override
    public Booking getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM booking WHERE BookingID = ?",s);
        if (resultSet.next()){
            return new Booking(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
            );
        }
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
        return SQLUtil.execute("DELETE FROM booking WHERE BookingID = ?",id);
    }

    @Override
    public List<String> getRunningIds() throws SQLException {
        List<String> bookings=new ArrayList<>();
        ResultSet resultSet=SQLUtil.execute("SELECT BookingID FROM booking WHERE Status='RUNNING'");
        while (resultSet.next()){
            bookings.add(resultSet.getString(1));
        }
        return bookings;
    }

    @Override
    public boolean setStatus(String id) throws SQLException {
        return SQLUtil.execute("UPDATE booking SET Status='FINISHED' WHERE BookingID=?",id);
    }

    @Override
    public List<String> getPendinngIds() throws SQLException {
        List<String> bookings=new ArrayList<>();
        ResultSet resultSet =SQLUtil.execute("SELECT BookingID FROM booking WHERE Status='PENDING'");
        while (resultSet.next()){
            bookings.add(resultSet.getString(1));
        }
        return bookings;
    }

    @Override
    public Double getDistance(String id) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT Distance FROM booking WHERE BookingID = ?",id);
        if (resultSet.next()){
            return resultSet.getDouble(1);
        }
        return 0.0;
    }

    @Override
    public boolean updateVehicleOutFromBooking(String id) throws SQLException {
        return SQLUtil.execute("UPDATE booking SET Status='RUNNING' WHERE BookingID=?",id);
    }

    @Override
    public int count() throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT count(*) from booking;");
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public int countRides() throws SQLException {
        Date now = Date.valueOf(LocalDate.now());
        ResultSet resultSet=SQLUtil.execute("SELECT count(*) from booking WHERE RequriedDate=?",now);
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }
}
