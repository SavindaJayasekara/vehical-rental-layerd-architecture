package lk.ijse.ikmanRental.dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T,ID> extends SuperDAO{
    boolean save(T entity)throws SQLException;
    boolean update(T entity)throws SQLException;
    boolean delete(ID id)throws SQLException;
    List<T> getAll()throws SQLException;
    T getIdes(ID id)throws SQLException;
}
