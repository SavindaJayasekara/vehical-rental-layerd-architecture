package lk.ijse.ikmanRental.bo.custom.impl;

import lk.ijse.ikmanRental.bo.custom.LogInBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.AdminDAO;
import lk.ijse.ikmanRental.dto.AdminDTO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.SQLException;

public class LogInBOImpl implements LogInBO {
    AdminDAO adminDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);
    @Override
    public AdminDTO getloginDetail(String text) throws SQLException {
        Admin admin = adminDAO.getIdes(text);
        return new AdminDTO(admin.getNIC(), admin.getFirstName(), admin.getLastName(), admin.getGmail(), admin.getPassword());
    }
}
