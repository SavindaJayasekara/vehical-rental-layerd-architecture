package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.VehicleDTO;

import java.sql.SQLException;
import java.util.List;

public interface VehicleBO extends SuperBO {
    List<String> loadVehicleNumbers()throws SQLException;

    List<VehicleDTO> getAll()throws SQLException;

    boolean saveVehicle(VehicleDTO vehicle)throws SQLException;

    boolean deleteVehicle(String number)throws SQLException;

    boolean updateVehicle(VehicleDTO vehicleDTO)throws SQLException;

    VehicleDTO getAllVehicle(String number)throws SQLException;
}
