package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.DriverPaymentDAO;
import lk.ijse.ikmanRental.entity.DriverPayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DriverPaymentDAOImpl implements DriverPaymentDAO{
    @Override
    public boolean save(DriverPayment dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(DriverPayment dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<DriverPayment> getAll() throws SQLException {
        return null;
    }

    @Override
    public DriverPayment getIdes(String s) throws SQLException {
        return null;
    }

    @Override
    public String getnextID() throws SQLException {
        ResultSet resultSet= SQLUtil.execute("SELECT PaymentID FROM payment ORDER BY PaymentID DESC LIMIT 1");
        if (resultSet.next()){
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    @Override
    public String splitOrderId(String currentId) {
        if(currentId != null) {
            String[] strings = currentId.split("O0");
            int id = Integer.parseInt(strings[0]);
            id++;
            return "00" + id;
        }
        return "00";
    }

    @Override
    public String getPaymentID(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean updatePayment(String driverNic) throws SQLException {
        return false;
    }
}
