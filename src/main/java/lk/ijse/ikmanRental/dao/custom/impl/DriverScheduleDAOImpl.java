package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.DriverScheduleDAO;
import lk.ijse.ikmanRental.entity.DriverSchedule;

import java.sql.SQLException;
import java.util.List;

public class DriverScheduleDAOImpl implements DriverScheduleDAO{
    @Override
    public boolean save(DriverSchedule dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(DriverSchedule dto) throws SQLException {
        return false;
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
        return null;
    }

    @Override
    public String getDriverNic(String bookingId) throws SQLException {
        return null;
    }

    @Override
    public String getDriverNicInRunning(String id) throws SQLException {
        return null;
    }
}
