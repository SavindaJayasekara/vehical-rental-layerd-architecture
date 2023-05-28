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
    public boolean save(Driver entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO driver (DriverNIC,Gamil,Name,Gender,Status)" +
                "VALUES(?, ?, ?, ?, ?)",entity.getNic(),entity.getGmail(),entity.getName(),entity.getGender(),entity.getStatus());
    }

    @Override
    public boolean update(Driver entity) throws SQLException {
        return SQLUtil.execute("UPDATE driver SET Gamil = ?, Name = ?, " +
                "Gender = ?,Status =? WHERE DriverNIC = ?",entity.getGmail(),entity.getName(),entity.getGender(),entity.getStatus(),entity.getNic());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return SQLUtil.execute("DELETE FROM driver WHERE DriverNIC = ?",s);
    }

    @Override
    public List<Driver> getAll() throws SQLException {
        List<Driver> drivers=new ArrayList<>();

        String sql="SELECT * FROM driver";

        ResultSet resultSet=SQLUtil.execute(sql);
        while (resultSet.next()){
            drivers.add(new Driver(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return drivers;
    }

    @Override
    public Driver getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM driver WHERE DriverNIC = ?",s);
        if (resultSet.next()){
            return new Driver(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
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
        ResultSet resultSet=SQLUtil.execute("SELECT count(*) from driver;");
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public String getGmail(String nic) throws SQLException {
        ResultSet resultSet= SQLUtil.execute("SELECT Gamil FROM driver WHERE DriverNIC=?",nic);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
