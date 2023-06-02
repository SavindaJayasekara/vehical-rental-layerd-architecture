package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Vehicle;

import java.sql.SQLException;
import java.util.List;

public interface VehicleDAO extends CrudDAO<Vehicle,String> {

     List<String> loadNumbers() throws SQLException ;

     List<String> getAvailbleType(String type) throws SQLException ;

     Vehicle getFuelToKm(String number) throws SQLException ;

     boolean updateAvailability(String vehicleNumber) throws SQLException ;

     boolean updateAvailabilityDelete(String vehicleNumber) throws SQLException ;

     int count() throws SQLException ;

     boolean updateAvailabilityRunning(String vehicleNumber,String status) throws SQLException ;
}
