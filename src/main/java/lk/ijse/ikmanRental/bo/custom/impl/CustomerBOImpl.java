package lk.ijse.ikmanRental.bo.custom.impl;
import lk.ijse.ikmanRental.bo.custom.CustomerBO;
import lk.ijse.ikmanRental.dao.DAOFactory;
import lk.ijse.ikmanRental.dao.custom.AdminDAO;
import lk.ijse.ikmanRental.dao.custom.CustomerDAO;
import lk.ijse.ikmanRental.dto.AdminDTO;
import lk.ijse.ikmanRental.dto.CustomerDTO;
import lk.ijse.ikmanRental.entity.Admin;
import lk.ijse.ikmanRental.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private final AdminDAO adminDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);
    private final CustomerDAO customerDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public AdminDTO getloginDetailFromAdmin(String gmail) throws SQLException {
        Admin adminDTO = adminDAO.getloginDetail(gmail);
        return new AdminDTO(adminDTO.getNIC(),adminDTO.getFirstName(),adminDTO.getLastName(),adminDTO.getGmail(),adminDTO.getPassword());
    }

    @Override
    public List<String> getCustomerNic() throws SQLException {
        return customerDAO.getCustomerNic();
    }

    @Override
    public boolean save(CustomerDTO customer) throws SQLException {
        return customerDAO.save(new Customer(customer.getNic(), customer.getGmail(), customer.getContact(), customer.getName(), customer.getAdminNic()));
    }

    @Override
    public boolean update(CustomerDTO customer) throws SQLException {
        return customerDAO.update(new Customer(customer.getNic(), customer.getGmail(), customer.getContact(), customer.getName(), customer.getAdminNic()));
    }

    @Override
    public boolean deleteCustomer(String nic) throws SQLException {
        return customerDAO.delete(nic);
    }

    @Override
    public List<String> loadAdminIds() throws SQLException {
        return adminDAO.loadAllIds();
    }

    @Override
    public List<CustomerDTO> getAllCustomer() throws SQLException {
        List<Customer> all = customerDAO.getAll();
        List<CustomerDTO> customerDTOS=new ArrayList<>();
        for (Customer customer: all){
            customerDTOS.add(new CustomerDTO(customer.getNic(),customer.getGmail(),customer.getContact(),customer.getName(),customer.getAdminNic()));
        }
        return customerDTOS;
    }

    @Override
    public CustomerDTO getAllCustomerFromId(String nic) throws SQLException {
        Customer customer = customerDAO.getIdes(nic);
        return new CustomerDTO(customer.getNic(),customer.getGmail(),customer.getContact(),customer.getName(),customer.getAdminNic());
    }
}
