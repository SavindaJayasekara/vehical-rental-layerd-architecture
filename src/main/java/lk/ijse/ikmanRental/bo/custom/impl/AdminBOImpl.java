package lk.ijse.ikmanRental.bo.custom.impl;

import com.sun.jdi.InvalidLineNumberException;
import lk.ijse.ikmanRental.bo.custom.AdminBO;
import lk.ijse.ikmanRental.dto.AdminDTO;

import java.sql.SQLException;
import java.util.List;

public class AdminBOImpl implements AdminBO {
    @Override
    public boolean save(AdminDTO admin) throws SQLException {
        return false;
    }

    @Override
    public void delete(String nic) {
        throw new InvalidLineNumberException("this feature not developed ! we will complete this ! ");
    }

    @Override
    public boolean update(AdminDTO admin) throws SQLException {
        return false;
    }

    @Override
    public AdminDTO getloginDetail(String gmail) throws SQLException {
        return null;
    }

    @Override
    public List<String> loadIds() throws SQLException {
        return null;
    }
}
