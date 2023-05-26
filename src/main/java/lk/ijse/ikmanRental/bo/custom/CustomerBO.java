package lk.ijse.ikmanRental.bo.custom;

import lk.ijse.ikmanRental.bo.SuperBO;
import lk.ijse.ikmanRental.dto.AdminDTO;
import lk.ijse.ikmanRental.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    AdminDTO getloginDetailFromAdmin(String gmail) throws SQLException;

    List<String> getCustomerNic()throws SQLException;

    boolean save(CustomerDTO customer) throws SQLException;

    boolean update(CustomerDTO customer) throws SQLException;

    boolean deleteCustomer(String nic) throws SQLException;

    List<String> loadAdminIds()throws SQLException;

    List<CustomerDTO> getAllCustomer() throws SQLException;

    CustomerDTO getAllCustomerFromId(String nic) throws SQLException;
}
