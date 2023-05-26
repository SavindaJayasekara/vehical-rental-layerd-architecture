package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Bill;

import java.sql.SQLException;

public interface BillDAO extends CrudDAO<Bill,String> {

     String getNextID() throws SQLException ;

     String splitOrderId(String currentId) ;

     String getBillid(String bookingID) throws SQLException ;
}
