package lk.ijse.ikmanRental.bo.custom.impl;

import com.sun.jdi.InvalidLineNumberException;
import lk.ijse.ikmanRental.bo.custom.AdminBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.AdminDAO;
import lk.ijse.ikmanRental.dto.AdminDTO;
import lk.ijse.ikmanRental.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public class AdminBOImpl implements AdminBO {

    AdminDAO adminDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);

    @Override
    public boolean save(AdminDTO adminDTO) throws SQLException {
        return adminDAO.save(new lk.ijse.ikmanRental.entity.Admin(adminDTO.getNIC(), adminDTO.getFirstName(), adminDTO.getLastName(), adminDTO.getGmail(), adminDTO.getPassword()));
    }

    @Override
    public void delete(String nic) {
        throw new InvalidLineNumberException("this feature not developed ! we will complete this ! ");
    }

    @Override
    public boolean update(AdminDTO adminDTO) throws SQLException {
        return adminDAO.update(new Admin(adminDTO.getNIC(), adminDTO.getFirstName(), adminDTO.getLastName(), adminDTO.getGmail(), adminDTO.getPassword()));
    }

    @Override
    public AdminDTO getloginDetail(String gmail) throws SQLException {
        Admin admin = adminDAO.getIdes(gmail);
        return new AdminDTO(admin.getNIC(),admin.getFirstName(),admin.getLastName(),admin.getGmail(),admin.getPassword());
    }

    @Override
    public List<String> loadIds() throws SQLException {
        return adminDAO.loadAllIds();
    }

    @Override
    public boolean saveAdmin(AdminDTO admin) throws SQLException {
        return adminDAO.save(new Admin(admin.getNIC(),admin.getFirstName(),admin.getLastName(),admin.getGmail(),admin.getPassword()));
    }
}
