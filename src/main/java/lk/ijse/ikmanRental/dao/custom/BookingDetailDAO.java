package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.BookingDetail;

import java.sql.SQLException;

public interface BookingDetailDAO extends CrudDAO<BookingDetail,String> {
//     boolean save(BookingDetail bookingDetail) throws SQLException ;

     String getVehicleNumber(String bookingID) throws SQLException ;

//     BookingDetail getAll(String id) throws SQLException ;

//     boolean delete(String id) throws SQLException ;

//     boolean update(BookingDetail bookingDetail) throws SQLException ;

     String getVehicleNUmberInRunning(String id) throws SQLException ;

     boolean setStatus(String id) throws SQLException ;
}
