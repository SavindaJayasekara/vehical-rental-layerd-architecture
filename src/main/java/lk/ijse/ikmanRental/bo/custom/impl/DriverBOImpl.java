package lk.ijse.ikmanRental.bo.custom.impl;

import lk.ijse.ikmanRental.bo.custom.DriverBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.DriverDAO;
import lk.ijse.ikmanRental.dao.custom.DriverPaymentDAO;
import lk.ijse.ikmanRental.dto.DriverDTO;
import lk.ijse.ikmanRental.dto.DriverPaymentDTO;
import lk.ijse.ikmanRental.entity.Driver;
import lk.ijse.ikmanRental.entity.DriverPayment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverBOImpl implements DriverBO {
    DriverDAO driverDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVER);
    DriverPaymentDAO paymentDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DRIVERPAYMENT);
    @Override
    public List<DriverPaymentDTO> getAllDrivePayment() throws SQLException {
        List<DriverPayment> all = paymentDAO.getAll();
        List<DriverPaymentDTO> paymentDTOS=new ArrayList<>();
        for (DriverPayment payment : all){
            paymentDTOS.add(new DriverPaymentDTO(payment.getPaymentID(),payment.getStatus(),payment.getPaymentCost(),payment.getDriverNic()));
        }
        return paymentDTOS;
    }

    @Override
    public List<DriverDTO> getAllDrivers() throws SQLException {
        List<Driver> all = driverDAO.getAll();
        List<DriverDTO> driverDTOS=new ArrayList<>();
        for (Driver driver : all){
            driverDTOS.add(new DriverDTO(driver.getNic(),driver.getGmail(),driver.getName(),driver.getGender(),driver.getStatus()));
        }
        return driverDTOS;
    }

    @Override
    public List<String> loadDriverNic() throws SQLException {
        return driverDAO.loadNic();
    }

    @Override
    public boolean saveDriver(DriverDTO driver) throws SQLException {
        return driverDAO.save(new Driver(driver.getNic(), driver.getGmail(), driver.getName(), driver.getGender(), driver.getStatus()));
    }

    @Override
    public DriverDTO getAllDriversFromNIC(String nic) {
        return null;
    }

    @Override
    public boolean updateDriver(DriverDTO driver) throws SQLException {
        return driverDAO.update(new Driver(driver.getNic(),driver.getGmail(),driver.getName(),driver.getGender(),driver.getStatus()));
    }

    @Override
    public boolean deleteDriver(String nicValue) throws SQLException {
        return driverDAO.delete(nicValue);
    }
}
