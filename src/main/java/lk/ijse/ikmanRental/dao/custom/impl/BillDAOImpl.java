package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.BillDAO;
import lk.ijse.ikmanRental.entity.Bill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BillDAOImpl implements BillDAO {

    @Override
    public boolean save(Bill dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Bill dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<Bill> getAll() throws SQLException {
        return null;
    }

    @Override
    public Bill getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM billing WHERE BookingID =?",s);
        if (resultSet.next()){
            return new Bill(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5),resultSet.getString(6),resultSet.getDate(7));
        }
        return null;
    }

    @Override
    public String getNextID() throws SQLException {
        ResultSet resultSet= SQLUtil.execute("SELECT BillID FROM billing ORDER BY BillID DESC LIMIT 1");
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
    public String getBillid(String bookingID) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT BillID FROM billing WHERE BookingID=?",bookingID);
        if (resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }
}
