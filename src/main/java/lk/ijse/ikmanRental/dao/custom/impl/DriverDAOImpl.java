package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.DriverDAO;
import lk.ijse.ikmanRental.entity.Driver;

import java.sql.SQLException;
import java.util.List;

public class DriverDAOImpl  implements DriverDAO{
    @Override
    public boolean save(Driver dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Driver dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<Driver> getAll() throws SQLException {
        return null;
    }

    @Override
    public Driver getIdes(String s) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadNic() throws SQLException {
        return null;
    }

    @Override
    public String getName(String driverNic) throws SQLException {
        return null;
    }

    @Override
    public Double getStatus(String driverNic) throws SQLException {
        return null;
    }

    @Override
    public String getType(String vehicleNumber) throws SQLException {
        return null;
    }

    @Override
    public int count() throws SQLException {
        return 0;
    }

    @Override
    public String getGmail(String nic) throws SQLException {
        return null;
    }
}
