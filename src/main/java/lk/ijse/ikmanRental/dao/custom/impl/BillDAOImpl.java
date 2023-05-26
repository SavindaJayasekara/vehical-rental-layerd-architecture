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
        return null;
    }
}
