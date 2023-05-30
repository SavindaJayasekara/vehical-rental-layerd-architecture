package lk.ijse.ikmanRental.bo.custom.impl;

import lk.ijse.ikmanRental.bo.custom.OTPVerifyBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.AdminDAO;
import lk.ijse.ikmanRental.dto.AdminDTO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.SQLException;

public class OTPVerifyBOImpl implements OTPVerifyBO {
    AdminDAO adminDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public boolean saveAdmin(AdminDTO admin) throws SQLException {
        return adminDAO.save(new Admin(admin.getNIC(),admin.getFirstName(),admin.getLastName(),admin.getGmail(),admin.getPassword()));
    }
}
