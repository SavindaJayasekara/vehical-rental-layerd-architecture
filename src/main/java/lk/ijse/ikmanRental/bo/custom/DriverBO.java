package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.DriverDTO;
import lk.ijse.ikmanRental.dto.DriverPaymentDTO;

import java.sql.SQLException;
import java.util.List;

public interface DriverBO extends SuperBO {
    List<DriverPaymentDTO> getAllDrivePayment() throws SQLException;

    List<DriverDTO> getAllDrivers() throws SQLException;

    List<String> loadDriverNic() throws SQLException;

    boolean saveDriver(DriverDTO driver) throws SQLException;

    DriverDTO getAllDriversFromNIC(String nic)throws SQLException;

    boolean updateDriver(DriverDTO driver) throws SQLException;

    boolean deleteDriver(String nicValue) throws SQLException;
}
