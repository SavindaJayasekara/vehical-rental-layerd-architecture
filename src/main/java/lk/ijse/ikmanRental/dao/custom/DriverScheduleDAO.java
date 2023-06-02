package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.DriverSchedule;

import java.sql.SQLException;

public interface DriverScheduleDAO extends CrudDAO<DriverSchedule,String> {

     String getDriverNic(String bookingId) throws SQLException ;

     String getDriverNicInRunning(String id) throws SQLException ;
}
