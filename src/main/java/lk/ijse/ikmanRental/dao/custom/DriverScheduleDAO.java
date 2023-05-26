package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.DriverSchedule;

import java.sql.SQLException;

public interface DriverScheduleDAO extends CrudDAO<DriverSchedule,String> {
//     boolean save(DriverSchedule driverSchedule) throws SQLException ;

     String getDriverNic(String bookingId) throws SQLException ;

//     DriverSchedule getAll(String id) throws SQLException ;

//     boolean delete(String id) throws SQLException ;

//     boolean update(DriverSchedule driverSchedule) throws SQLException ;

     String getDriverNicInRunning(String id) throws SQLException ;
}
