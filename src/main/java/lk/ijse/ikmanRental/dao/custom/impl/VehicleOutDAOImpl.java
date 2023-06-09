package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.VehicleOutDAO;
import lk.ijse.ikmanRental.entity.VehicleOut;

import java.sql.SQLException;
import java.util.List;

public class VehicleOutDAOImpl implements VehicleOutDAO {
    @Override
    public boolean save(VehicleOut entity) throws SQLException {

        return SQLUtil.execute("INSERT INTO vehicleout (VehicleNumber,DriverNIC,Distance,BookingID)" +
                "VALUES(?, ?, ? ,?)",
                entity.getVehicleNumber(),
                entity.getDriverNic(),
                entity.getDistance(),
                entity.getBookingId()
        );
    }

    @Override
    public boolean update(VehicleOut dto) {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public boolean delete(String s) {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public List<VehicleOut> getAll() {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public VehicleOut getIdes(String s) {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }
}
