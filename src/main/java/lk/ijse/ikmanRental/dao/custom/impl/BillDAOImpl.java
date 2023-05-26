package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.BillDAO;
import lk.ijse.ikmanRental.entity.Bill;

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
        return null;
    }

    @Override
    public String splitOrderId(String currentId) {
        return null;
    }

    @Override
    public String getBillid(String bookingID) throws SQLException {
        return null;
    }
}
