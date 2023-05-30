package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.AdminDTO;

import java.sql.SQLException;

public interface OTPVerifyBO extends SuperBO {
    boolean saveAdmin(AdminDTO admin)throws SQLException;
}
