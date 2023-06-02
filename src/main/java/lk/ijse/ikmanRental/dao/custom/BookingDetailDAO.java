package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.BookingDetail;

import java.sql.SQLException;

public interface BookingDetailDAO extends CrudDAO<BookingDetail,String> {

     String getVehicleNumber(String bookingID) throws SQLException ;

     String getVehicleNUmberInRunning(String id) throws SQLException ;

}
