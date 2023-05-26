package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.DriverDAO;
import lk.ijse.ikmanRental.entity.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        List<String> nic=new ArrayList<>();
        ResultSet resultSet = null;
        resultSet= SQLUtil.execute("SELECT DriverNIC FROM driver");
        while (resultSet.next()){
            nic.add(resultSet.getString(1));
        }
        return nic;
    }

    @Override
    public String getName(String driverNic) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT Name FROM driver WHERE DriverNIC=?",driverNic);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public Double getStatus(String driverNic) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT Status FROM driver WHERE DriverNIC=?",driverNic);
        if (resultSet.next()){
            return resultSet.getDouble(1);
        }
        return 0.0;
    }

    @Override
    public String getType(String driverNic) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT Type FROM vehicle WHERE VehicleNumber=?",driverNic);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
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
