package lk.ijse.ikmanRental.dao.custom.impl;

import lk.ijse.ikmanRental.dao.SQLUtil;
import lk.ijse.ikmanRental.dao.custom.VehicleDAO;
import lk.ijse.ikmanRental.entity.Vehicle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO{
    @Override
    public boolean save(Vehicle entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO vehicle(VehicleNumber,Name,Type,FuelToKm,KMH,Availability,Status,Conditions)" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
                entity.getVehicleNumber(),
                entity.getName(),
                entity.getType(),
                entity.getFuelToKm(),
                entity.getKmh(),
                entity.getAvailability(),
                entity.getStatus(),
                entity.getCondition()
        );
    }

    @Override
    public boolean update(Vehicle entity) throws SQLException {
        return SQLUtil.execute("UPDATE vehicle SET Name = ?, Type = ?, " +
                "FuelToKm = ?,KMH =?,Availability =?,Status=?,Conditions=? WHERE VehicleNumber = ?",entity.getName(),entity.getType(),entity.getFuelToKm(),entity.getKmh(),entity.getAvailability(),entity.getStatus(),entity.getCondition(),entity.getVehicleNumber());
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return SQLUtil.execute("DELETE FROM vehicle WHERE VehicleNumber = ?",s);
    }

    @Override
    public List<Vehicle> getAll() throws SQLException {
        List<Vehicle> vehicles=new ArrayList<>();
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM vehicle");
        while (resultSet.next()){
            vehicles.add(new Vehicle(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)

            ));
        }
        return vehicles;
    }

    @Override
    public Vehicle getIdes(String s) throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT * FROM vehicle WHERE VehicleNumber = ?",s);
        if (resultSet.next()){
            return new Vehicle(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            );
        }
            return null;
    }

    @Override
    public List<String> loadNumbers() throws SQLException {
        List<String> numbers = new ArrayList<>();
        ResultSet resultSet=SQLUtil.execute("SELECT VehicleNumber FROM vehicle");
        while (resultSet.next()){
            numbers.add(resultSet.getString(1));
        }
        return numbers;
    }

    @Override
    public List<String> getAvailbleType(String type) throws SQLException {
        List<String> idList =new ArrayList<>();
        ResultSet resultSet= SQLUtil.execute("SELECT VehicleNumber FROM vehicle WHERE Type=? && Availability='AVAILABLE';",type);
        while (resultSet.next()){
            idList.add(resultSet.getString(1));
        }
        return idList;
    }

    @Override
    public Vehicle getFuelToKm(String number) throws SQLException {
        Vehicle vehicle = new Vehicle();
        ResultSet resultSet=SQLUtil.execute("SELECT FuelToKm, Status FROM vehicle WHERE VehicleNumber=?",number);
        if (resultSet.next()){
            vehicle.setFuelToKm(resultSet.getDouble(1));
            vehicle.setStatus(resultSet.getString(2));
        }
        return vehicle;
    }

    @Override
    public boolean updateAvailability(String vehicleNumber) throws SQLException {
        String status="BOOKED";
        return SQLUtil.execute("UPDATE vehicle SET Availability=? WHERE VehicleNumber = ?",status,vehicleNumber);
    }

    @Override
    public boolean updateAvailabilityDelete(String vehicleNumber) throws SQLException {
        String availability="AVAILABLE";
        return SQLUtil.execute("UPDATE vehicle SET Availability=? WHERE VehicleNumber = ?",availability,vehicleNumber);
    }

    @Override
    public int count() throws SQLException {
        ResultSet resultSet=SQLUtil.execute("SELECT count(*) from vehicle WHERE Availability='AVAILABLE';");
        if (resultSet.next()){
            return resultSet.getInt(1);
        }
        return 0;
    }

    @Override
    public boolean updateAvailabilityRunning(String vehicleNumber, String status) throws SQLException {
        return SQLUtil.execute("UPDATE vehicle SET Availability=? WHERE VehicleNumber = ?",status,vehicleNumber);
    }
}
