package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.VehicleInDAO;
import lk.ijse.ikmanRental.entity.VehicleIn;

import java.sql.SQLException;
import java.util.List;

public class VehicleInDAOImpl implements VehicleInDAO{
    @Override
    public boolean save(VehicleIn dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(VehicleIn dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<VehicleIn> getAll() throws SQLException {
        return null;
    }

    @Override
    public VehicleIn getIdes(String s) throws SQLException {
        return null;
    }
}
