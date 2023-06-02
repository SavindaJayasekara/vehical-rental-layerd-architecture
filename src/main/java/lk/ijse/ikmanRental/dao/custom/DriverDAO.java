package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Driver;

import java.sql.SQLException;
import java.util.List;

public interface DriverDAO extends CrudDAO<Driver,String> {

    List<String> loadNic() throws SQLException ;

     String getName(String driverNic) throws SQLException ;

     Double getStatus(String driverNic) throws SQLException ;

     String getType(String vehicleNumber) throws SQLException ;

     int count() throws SQLException ;

     String getGmail(String nic) throws SQLException;
}
