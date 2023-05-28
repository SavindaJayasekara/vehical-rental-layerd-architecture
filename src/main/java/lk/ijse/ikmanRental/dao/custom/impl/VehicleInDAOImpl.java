package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.VehicleInDAO;
import lk.ijse.ikmanRental.entity.VehicleIn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleInDAOImpl implements VehicleInDAO{
    @Override
    public boolean save(VehicleIn entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO vehiclein (VehicleNumber,DriverNIC,CurrentDate,BookingID)" +
                        "VALUES (?, ?, ?, ?)",
                entity.getVehicleNumber(),
                entity.getDriverNic(),
                entity.getDate(),
                entity.getBookingId()
        );
    }

    @Override
    public boolean update(VehicleIn dto) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<VehicleIn> getAll() throws SQLException {
        List<VehicleIn> inList=new ArrayList<>();
        ResultSet resultSet= SQLUtil.execute("SELECT * FROM vehiclein");
        while (resultSet.next()){
            inList.add(new VehicleIn(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDate(3),
                            resultSet.getString(4)
                    )
            );
        }
        return inList;
    }

    @Override
    public VehicleIn getIdes(String s) throws SQLException {
        return null;
    }
}
