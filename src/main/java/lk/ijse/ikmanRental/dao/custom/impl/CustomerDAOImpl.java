package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.CustomerDAO;
import lk.ijse.ikmanRental.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl  implements CustomerDAO{
    @Override
    public boolean save(Customer customer) throws SQLException {
        return SQLUtil.execute("INSERT INTO customer (CustomerNIC,Gamil,Contact,Name,AdminNIC)" +
                        "VALUES(?, ?, ?, ?, ?)",customer.getNic(),
                customer.getGmail(),
                customer.getContact(),
                customer.getName(),
                customer.getAdminNic()
        );
    }

    @Override
    public boolean update(Customer entity) throws SQLException {
        return SQLUtil.execute("UPDATE customer SET Name = ?, Contact = ?, " +
                "Gamil = ? WHERE CustomerNIC = ?",entity.getName(),entity.getContact(),entity.getGmail(),entity.getNic());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE CustomerNIC = ?",s);
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> data = new ArrayList<>();

        ResultSet resultSet = null;
        try {
            resultSet = SQLUtil.execute("SELECT * FROM Customer");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (resultSet.next()) {
            data.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return data;
    }

    @Override
    public Customer getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM customer WHERE CustomerNIC = ?",s);
        if (resultSet.next()){
            return new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
        }
        return null;
    }

    @Override
    public List<String> getCustomerNic() throws SQLException {
        List<String> ides=new ArrayList<>();
        ResultSet resultSet= SQLUtil.execute("SELECT CustomerNIC FROM customer");
        while (resultSet.next()){
            ides.add(resultSet.getString(1));
            return ides;
        }
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
