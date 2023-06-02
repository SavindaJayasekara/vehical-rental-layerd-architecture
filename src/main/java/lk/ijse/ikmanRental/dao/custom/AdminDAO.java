package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO extends CrudDAO<Admin,String> {

     Admin getloginDetail(String gmail) throws SQLException ;

     List<String> loadAllIds() throws SQLException ;

}
