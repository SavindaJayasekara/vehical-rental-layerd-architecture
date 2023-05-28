package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.BookingDAO;
import lk.ijse.ikmanRental.dao.custom.BookingDetailDAO;
import lk.ijse.ikmanRental.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookingDetailDAOImpl implements BookingDetailDAO {

    @Override
    public boolean save(BookingDetail entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO bookingdetail(BookingID,VehicleNumber,fuel)" +
                "VALUES(?, ?, ?)",entity.getBookingId(),entity.getVehicleNumber(),entity.getFuel());
    }

    @Override
    public boolean update(BookingDetail entity) throws SQLException {
        return SQLUtil.execute("UPDATE bookingdetail SET VehicleNumber=? ,fuel=? WHERE BookingID=?",entity.getVehicleNumber(),entity.getFuel(),entity.getBookingId());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return SQLUtil.execute("DELETE FROM bookingdetail WHERE BookingID = ?",s);
    }

    @Override
    public List<BookingDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public BookingDetail getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM bookingdetail WHERE BookingID =?",s);
        if (resultSet.next()){
            return new BookingDetail(resultSet.getString(1),resultSet.getString(2),resultSet.getDouble(3));
        }
        return null;
    }

    @Override
    public String getVehicleNumber(String bookingID) throws SQLException {
        ResultSet resultSet= SQLUtil.execute("SELECT VehicleNumber FROM bookingdetail WHERE BookingID =?",bookingID);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public String getVehicleNUmberInRunning(String id) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT VehicleNumber FROM bookingdetail WHERE BookingID=?",id);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

   }
