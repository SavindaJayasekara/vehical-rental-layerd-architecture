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
        ResultSet resultSet=SQLUtil.execute("SELECT Gamil,Password,FirsName,LastName,AdminNIC FROM admin WHERE Gamil=?",s);
        if (resultSet.next()){
            return new Admin(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        }
        return null;
    }

    @Override
    public Admin getloginDetail(String gmail) throws SQLException {

        ResultSet resultSet=SQLUtil.execute("SELECT Gamil,Password,FirsName,LastName,AdminNIC FROM admin WHERE Gamil=?",gmail);
        if (resultSet.next()){
            return new Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
        }
        return null;
    }

    @Override
    public List<String> loadAllIds() throws SQLException {
        List<String> data = new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT AdminNIC FROM admin");
        while (resultSet.next()) {
            data.add(resultSet.getString(1));
        }
        return data;
    }
}
