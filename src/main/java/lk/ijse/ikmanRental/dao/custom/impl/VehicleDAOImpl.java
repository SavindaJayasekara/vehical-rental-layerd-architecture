package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.VehicleDAO;
import lk.ijse.ikmanRental.entity.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO{
    @Override
    public boolean save(Vehicle dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Vehicle dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<Vehicle> getAll() throws SQLException {
        return null;
    }

    @Override
    public Vehicle getIdes(String s) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadNumbers() throws SQLException {
        return null;
    }

    @Override
    public List<String> getAvailbleType(String type) throws SQLException {
        return null;
    }

    @Override
    public Vehicle getFuelToKm(String number) throws SQLException {
        return null;
    }

    @Override
    public boolean updateAvailability(String vehicleNumber) throws SQLException {
        return false;
    }

    @Override
    public boolean updateAvailabilityDelete(String vehicleNumber) throws SQLException {
        return false;
    }

    @Override
    public int count() throws SQLException {
        return 0;
    }

    @Override
    public boolean updateAvailabilityRunning(String vehicleNumber, String status) throws SQLException {
        return false;
    }
}
