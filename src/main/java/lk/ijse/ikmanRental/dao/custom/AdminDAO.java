package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO extends CrudDAO<Admin,String> {

//    public static boolean save(Admin admin) throws SQLException ;

//    public static void delete(String nic){}

//    public static boolean update(Admin admin) throws SQLException ;

//     Admin getloginDetail(String gmail) throws SQLException ;

     List<String> loadAllIds() throws SQLException ;

}
