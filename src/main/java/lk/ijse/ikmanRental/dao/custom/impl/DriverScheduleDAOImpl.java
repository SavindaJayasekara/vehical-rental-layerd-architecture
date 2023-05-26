package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.DriverScheduleDAO;
import lk.ijse.ikmanRental.entity.DriverSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DriverScheduleDAOImpl implements DriverScheduleDAO{
    @Override
    public boolean save(DriverSchedule entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO drivershedeul(BookingID,DriverNIC)" +
                "VALUES(?, ?)",entity.getBookingID(),entity.getDriverNic());
    }

    @Override
    public boolean update(DriverSchedule entity) throws SQLException {
        return SQLUtil.execute("UPDATE drivershedeul SET DriverNIC=? WHERE BookingID=?",entity.getDriverNic(),entity.getBookingID());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<DriverSchedule> getAll() throws SQLException {
        return null;
    }

    @Override
    public DriverSchedule getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM drivershedeul WHERE BookingID =?",s);
        if (resultSet.next()){
            return new DriverSchedule(resultSet.getString(1),resultSet.getString(2));
        }
        return null;
    }

    @Override
    public String getDriverNic(String bookingId) throws SQLException {
        ResultSet resultSet= SQLUtil.execute("SELECT DriverNIC FROM drivershedeul WHERE BookingID =?",bookingId);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public String getDriverNicInRunning(String id) throws SQLException {
        return null;
    }
}
