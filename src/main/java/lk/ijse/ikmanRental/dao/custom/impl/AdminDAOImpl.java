package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.AdminDAO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO admin (AdminNIC,FirsName,LastName,Gamil,Password)" +
                "VALUES(?, ?, ?, ?, ?)",entity.getNIC(),entity.getFirstName(),entity.getLastName(),entity.getGmail(),entity.getPassword());
    }

    @Override
    public boolean update(Admin entity) throws SQLException {
        return SQLUtil.execute("UPDATE admin SET FirsName  = ?, LastName = ?, " +
                "Gamil = ?,Password=?  WHERE AdminNIC = ?",entity.getFirstName(),entity.getLastName(),entity.getGmail(),entity.getPassword(),entity.getNIC());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        throw new UnsupportedOperationException("This feature yet to be developed");
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
        List<String> data = new ArrayList<>();

        String sql="SELECT AdminNIC FROM admin";

        ResultSet resultSet = null;
        try {
            resultSet = SQLUtil.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }
}
