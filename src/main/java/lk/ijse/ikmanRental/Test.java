package lk.ijse.ikmanRental;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        Admin1 admin=new Admin1();
        try {
           Admin ides = admin.getIdes("thantrige32@gmail.com");
            System.out.println(ides.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
class Admin1{
    public lk.ijse.ikmanRental.entity.Admin getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT Gamil,Password,FirsName,LastName,AdminNIC FROM admin WHERE Gamil=?",s);
        if (resultSet.next()){
            return new Admin(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
        }
        return null;
    }
}
