package lk.ijse.ikmanRental.dao.custom;

import lk.ijse.ikmanRental.dao.CrudDAO;
import lk.ijse.ikmanRental.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer,String> {

    List<String> getCustomerNic() throws SQLException;

    String getName(String driverNic) throws SQLException;

    int countCustomer() throws SQLException;
}
