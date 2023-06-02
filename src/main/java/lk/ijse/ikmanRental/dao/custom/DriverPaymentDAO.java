package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.DriverPayment;

import java.sql.SQLException;

public interface DriverPaymentDAO extends CrudDAO<DriverPayment,String> {
     String getnextID() throws SQLException ;

     String splitOrderId(String currentId) ;

     String getPaymentID(String id) throws SQLException ;

     boolean updatePayment(String driverNic) throws SQLException ;

}
