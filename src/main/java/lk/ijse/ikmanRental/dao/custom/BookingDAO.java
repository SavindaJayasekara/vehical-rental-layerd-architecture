package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface BookingDAO extends CrudDAO<Booking,String> {
    String getNextBookingID() throws SQLException ;

    String splitOrderId(String currentId) ;

    List<String> getBookingIds() throws SQLException ;

     boolean deleteBooking(String id) throws SQLException ;

    List<String> getRunningIds() throws SQLException ;

    boolean setStatus(String id) throws SQLException ;

    List<String> getPendinngIds() throws SQLException ;

    Double getDistance(String id) throws SQLException ;

    boolean updateVehicleOutFromBooking(String id) throws SQLException ;

    int count() throws SQLException ;

    int countRides() throws SQLException ;
}
