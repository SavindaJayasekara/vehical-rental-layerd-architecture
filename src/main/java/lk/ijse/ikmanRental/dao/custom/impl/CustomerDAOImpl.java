package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.custom.CustomerDAO;
import lk.ijse.ikmanRental.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl  implements CustomerDAO{
    @Override
    public boolean save(Customer dto) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Customer dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return null;
    }

    @Override
    public Customer getIdes(String s) throws SQLException {
        return null;
    }

    @Override
    public List<String> getCustomerNic() throws SQLException {
        return null;
    }

    @Override
    public String getName(String driverNic) throws SQLException {
        return null;
    }

    @Override
    public int countCustomer() throws SQLException {
        return 0;
    }
}
