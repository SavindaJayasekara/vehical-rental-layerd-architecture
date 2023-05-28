package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.VehicleInDTO;
import lk.ijse.ikmanRental.dto.VehicleOutDTO;

import java.sql.SQLException;
import java.util.List;

public interface HomeBO extends SuperBO {
    List<VehicleInDTO> getAllVehicleIn() throws SQLException;

    int countCustomer()throws SQLException;

    int countVehicle()throws SQLException;

    int countBookings()throws SQLException;

    int countDriver()throws SQLException;

    int countRidesFromBooking()throws SQLException;

    List<String> getPendinngIdsFromBooking()throws SQLException;

    List<String> getRunningIdsFromBooking()throws SQLException;

    String getVehicleNUmberInRunning(String id)throws SQLException;

    String getDriverNicInRunning(String id)throws SQLException;

    boolean saveVehicleIn(VehicleInDTO vehicleIn, String id, String vehiclenumber, String available, String driverId)throws SQLException;

    Double getDistanceFromBooking(String id)throws SQLException;

    boolean saveVehicleOut(VehicleOutDTO vehicle, String id, String vehicleNumber, String running) throws SQLException;
}
