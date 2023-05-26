package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer,String> {
//    boolean save(Customer customer) throws SQLException;
//
//    List<Customer> getAll() throws SQLException;
//
    List<String> getCustomerNic() throws SQLException;
//
//    Customer getAllCustomer(String nic) throws SQLException;
//
//    boolean delete(String nic) throws SQLException;
//
//    boolean update(Customer customer) throws SQLException;

    String getName(String driverNic) throws SQLException;

    int countCustomer() throws SQLException;
}
