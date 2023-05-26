package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.AdminDTO;

import java.sql.SQLException;
import java.util.List;

public interface AdminBO extends SuperBO {
     boolean save(AdminDTO admin) throws SQLException;

     void delete(String nic);

     boolean update(AdminDTO admin) throws SQLException;

     AdminDTO getloginDetail(String gmail) throws SQLException;

     List<String> loadIds() throws SQLException;
}