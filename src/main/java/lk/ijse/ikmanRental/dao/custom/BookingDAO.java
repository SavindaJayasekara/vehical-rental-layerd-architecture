package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface BookingDAO extends CrudDAO<Booking,String> {
    String getNextBookingID() throws SQLException ;

    String splitOrderId(String currentId) ;

    boolean addBooking(Booking booking, Bill bill, DriverPayment driverPay, DriverSchedule driverSchedule, BookingDetail bookingDetail) throws SQLException ;

//     boolean save(Booking booking) throws SQLException ;

//    List<Booking> getAll() throws SQLException ;

    List<String> getBookingIds() throws SQLException ;

//    Booking getAllFromID(String id) throws SQLException ;

//    boolean delete(String id) throws SQLException ;

     boolean deleteBooking(String id) throws SQLException ;


//    boolean update(Booking booking, Bill bill, DriverPayment driverPay, DriverSchedule driverSchedule, BookingDetail bookingDetail) throws SQLException ;

//     boolean updateBooking(Booking booking) throws SQLException ;

    List<String> getRunningIds() throws SQLException ;

    boolean setStatus(String id) throws SQLException ;

    List<String> getPendinngIds() throws SQLException ;

    Double getDistance(String id) throws SQLException ;

    boolean updateVehicleOut(String id) throws SQLException ;

    int count() throws SQLException ;

    int countRides() throws SQLException ;
}
