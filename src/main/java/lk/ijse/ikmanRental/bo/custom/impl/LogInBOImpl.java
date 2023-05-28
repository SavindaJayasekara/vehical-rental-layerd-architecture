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

//        AdminDTO admin1 = new AdminDTO();
//
//        Connection connection= DBConnection.getInstance().getConnection();
//
//        String sql="SELECT Gamil,Password,FirsName,LastName,AdminNIC FROM admin WHERE Gamil=?";
//        String sql1="SELECT * FROM admin";
//
//        PreparedStatement pstm = connection.prepareStatement(sql);
//        pstm.setString(1, text);
//
//        ResultSet resultSet=pstm.executeQuery();
//
//        if (resultSet.next()) {
//            admin1.setGmail(resultSet.getString(1));
//            admin1.setPassword(resultSet.getString(2));
//            admin1.setFirstName(resultSet.getString(3));
//            admin1.setLastName(resultSet.getString(4));
//            admin1.setNIC(resultSet.getString(5));
//        }
//        return admin1;
        Admin admin = adminDAO.getloginDetail(text);
        return new AdminDTO(admin.getNIC(), admin.getFirstName(), admin.getLastName(), admin.getGmail(), admin.getPassword());
    }
}
