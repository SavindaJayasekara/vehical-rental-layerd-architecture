package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.AdminDAO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin dto) throws SQLException {
        return SQLUtil.execute("INSERT INTO admin (AdminNIC,FirsName,LastName,Gamil,Password)" +
                "VALUES(?, ?, ?, ?, ?)",dto.getNIC(),dto.getFirstName(),dto.getLastName(),dto.getGmail(),dto.getPassword());
    }

    @Override
    public boolean update(Admin dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<Admin> getAll() throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public Admin getIdes(String s) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadAllIds() throws SQLException {
        return null;
    }
}
