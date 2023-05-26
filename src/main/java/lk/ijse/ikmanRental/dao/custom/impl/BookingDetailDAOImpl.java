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
        return false;
    }

    @Override
    public boolean update(BookingDetail entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<BookingDetail> getAll() throws SQLException {
        return null;
    }

    @Override
    public BookingDetail getIdes(String s) throws SQLException {
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
        return null;
    }

    @Override
    public boolean setStatus(String id) throws SQLException {
        return false;
    }
}
